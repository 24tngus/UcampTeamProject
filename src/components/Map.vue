<template>
  <GoogleMap
      api-key="AIzaSyB21eMRg-uMRk-i7r27DPDkntXbR5_kvnk"
      style="width: 100%; height: 500px"
      :center="center"
      :zoom="17"
      language="kor"
      @keyup.enter="mapEnter"
  >
    <MarkerCluster>
      <Marker v-for="(location, i) in locations" :options="{ position: location }" :key="i"
              @click="showPlaceIdInfo()">
        <InfoWindow>  <!-- Marker 클릭하면 나오는 부분 -->
          <div id="contet">
            <div id="siteNotice"></div> <!--  -->
            <h1 id="firstHeading" class="firstHeading" v-if="detailPlaceInfo" href="/">{{ this.detailPlaceInfo.name }}</h1> <!-- 가게 이름 -->
            <div id="bodyContent">
              <p v-if="detailPlaceInfo">  <!-- 도로명 주소 formatted_address -->
                {{ this.detailPlaceInfo.formatted_address }}
              </p>
              <p v-if="detailPlaceInfo">  <!-- 별점 rating -->
                {{ this.detailPlaceInfo.rating }}
              </p>
              <div>
                <img src="https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference=AcJnMuEOKrWrFJWjgJ0hP9z6YEAW_sFK_EjE8YGfW4OpXVjrKGOFylnNfvubR_pNu19Gpob7ftOzYggMoq2wWtToKc0LQkhMRBll8X5HDuBpME1W9VYH8JmSYj_VeQL2vny-bKmEP-tSFfFAcpdf1AMwpdF6VrLEaXUzsRoj4qemUB_ekuhk&key=AIzaSyB21eMRg-uMRk-i7r27DPDkntXbR5_kvnk">
              </div>
              <div v-if="dbInputData.detailinfo">
                {{ this.dbInputData.detailinfo }}
              </div>
            </div>
          </div>
        </InfoWindow>
      </Marker>
    </MarkerCluster>
  </GoogleMap>
</template>

<script>
import { defineComponent } from 'vue'
import { GoogleMap, Marker, MarkerCluster, InfoWindow } from 'vue3-google-map'
import axios from "axios";

export default defineComponent({
  components: {GoogleMap, Marker, MarkerCluster, InfoWindow},
  setup() {
    // googleMap에 Marker 세팅
    const locations = [
      {lat: 37.5593773, lng: 126.832661},
      {lat: 37.55795, lng: 126.8397055},
    ]
    return { locations }
  },  // setup()
  data() {
    return {
      center : {lat: 37.561736, lng: 126.835419},  // googleMap의 처음 시작 좌표
      jsonData : null,  // nearby search로 얻은 주변 전체 JSON Data
      detailPlaceInfo : null, // place_id로 얻은 한 장소에 대한 JSON Data
      dbInputData : { // db에 넣기 위한 객체
        storename : '',
        placeid : '',
        detailinfo : '',
        location : '',
        rating : '',
        phonenumber : '',
        lat : '',
        lng : '',
        image1: '',
        image2: '',
        image3: '',
        image4: '',
        image5: '',
      },
      // db에서 받아와 지도 현위치 기능에 쓰일 lat, lng, place_id
      dbLat: '',
      dbLng: '',
      dbPlaceId: '',
    };
  },  // data()
  async mounted() {

    try {
      // getCurrentUserLocation()으로 user의 currentLocation을 googleMap center로 설정
      this.center = await this.getCurrentUserLocation();
    } catch (error) {
      console.log("Error User Location : " + error);
    }

    this.setInputData();
  },  // mounted()
  computed: {
  },  // computed
  methods: {
    async showPlaceIdInfo () {  // place_id로 googleMap JSON Data를 Parsing
      fetch('https://proxy.cors.sh/https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJrQcG0R-dfDUREPJPWnn6jv0&key=AIzaSyB21eMRg-uMRk-i7r27DPDkntXbR5_kvnk', {
        headers: {
          'x-cors-api-key': 'temp_924d232f48d59dabc25af9778ab72f25'
        }
      })
          .then(res => res.json())
          .then(res => {
            this.detailPlaceInfo = res.result;
          })

    },  // showPlaceIdInfo
    getCurrentUserLocation: function () {  // User의 현재 위치 가져오기
      return new Promise((resolve, reject) => {
        navigator.geolocation.getCurrentPosition(
            (position) => {
              const location = {
                enableHighAccuracy: true, // 정확도 향상
                lat: position.coords.latitude,
                lng: position.coords.longitude,
              };

              resolve(location);
            },
            (error) => {
              reject(error);
            }
        )
      })
    }, // getCurrentUserLocation
    async setInputData() {  // nearbysearch로 얻은 데이터를 db에 넣기 전 dbInputData 객체에 세팅
      let jsonData;
      fetch(`https://proxy.cors.sh/https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=${this.center.lat},%20${this.center.lng}&rankby=distance&name=채식&key=AIzaSyB21eMRg-uMRk-i7r27DPDkntXbR5_kvnk`, {
        headers: {
          'x-cors-api-key': 'temp_924d232f48d59dabc25af9778ab72f25'
        }
      })
          .then(res => res.json())
          .then(async res => {
            jsonData = res;

            // 최대 20개의 데이터를 dbInputData에 담는다
            this.dbInputData = jsonData.results.slice(0, 20)
                .filter(data => data.rating>=4 )  //data의 rating이 4 이상이어야 입력
                .map(data => ({
                  storename: data.name,
                  placeid: data.place_id,

                  location: data.vicinity,
                  rating: data.rating,
                  lat: data.geometry.location.lat,
                  lng: data.geometry.location.lng,
                }));

            // data.place_id 값을 setInputData_placeid 메서드로 전달
            this.dbInputData.forEach(data => {
              this.setInputData_placeid(data.placeid);
            });
          });
    }, // setInputData
    // place_id로 가져온 api로 dbInputData에 입력
    async setInputData_placeid(temp_place_id) {
      let jsonData;
      fetch(`https://proxy.cors.sh/https://maps.googleapis.com/maps/api/place/details/json?placeid=${temp_place_id}&key=AIzaSyB21eMRg-uMRk-i7r27DPDkntXbR5_kvnk`, {
        headers: {
          'x-cors-api-key': 'temp_924d232f48d59dabc25af9778ab72f25'
        }
      })
          .then(res => res.json())
          .then(async res => {
            jsonData = res;

            // detailinfo에 weekday_text 배열 안의 문자열을 하나씩 붙여서 담을 임시 변수
            let temp_detailinfo = '';

            // 위에서 forEach로 돌면서 다 가져옴
            // place_id가 일치하면 phonenumber를 저장
            for (let i=0; i<this.dbInputData.length; i++) {
              if (this.dbInputData[i].placeid === temp_place_id) {
                this.dbInputData[i].phonenumber = jsonData.result.formatted_phone_number;
                // 일주일의 영업 정보를 detailinfo에 저장
                if(jsonData.result && jsonData.result.opening_hours && jsonData.result.opening_hours.weekday_text){
                  for(let k=0; k<jsonData.result.opening_hours.weekday_text.length; k++){
                    if(jsonData.result.opening_hours.weekday_text[k])
                      temp_detailinfo += (jsonData.result.opening_hours.weekday_text[k] + "\n");
                  }
                  this.dbInputData[i].detailinfo = temp_detailinfo;
                }

                break; // 원하는 요소를 찾았으면 루프 종료
              }
            }

            // image 저장
            for (let i = 0; i < this.dbInputData.length; i++) {
              if (this.dbInputData[i].placeid === temp_place_id) {
                if(jsonData.result && jsonData.result.photos && jsonData.result.photos.length>6) {
                  if (jsonData.result.photos[0].photo_reference)
                    this.dbInputData[i].image1 = jsonData.result.photos[0].photo_reference;

                  if (jsonData.result.photos[1].photo_reference)
                    this.dbInputData[i].image2 = jsonData.result.photos[1].photo_reference;

                  if (jsonData.result.photos[2].photo_reference)
                    this.dbInputData[i].image3 = jsonData.result.photos[2].photo_reference;

                  if (jsonData.result.photos[3].photo_reference)
                    this.dbInputData[i].image4 = jsonData.result.photos[3].photo_reference;

                  if (jsonData.result.photos[4].photo_reference)
                    this.dbInputData[i].image5 = jsonData.result.photos[4].photo_reference;

                  break; // 원하는 요소를 찾았으면 루프 종료
                }

              }

              // dbInputData에 뭐가 들어갔는지 확인하는 부분. 나중에 지우자
              // console.log("★★★ after " + this.dbInputData[i].storename)
              // console.log("★★★ after " + this.dbInputData[i].placeid)
              // console.log("★★★ after " + this.dbInputData[i].detailinfo)
              // console.log("★★★ after " + this.dbInputData[i].location)
              // console.log("★★★ after " + this.dbInputData[i].rating)
              // console.log("★★★ after " + this.dbInputData[i].phonenumber)
              // console.log("★★★ after " + this.dbInputData[i].lat)
              // console.log("★★★ after " + this.dbInputData[i].lng)
              // console.log("★★★ after " + this.dbInputData[i].image1)
              // console.log("★★★ after " + this.dbInputData[i].image2)
              // console.log("★★★ after " + this.dbInputData[i].image3)
              // console.log("★★★ after " + this.dbInputData[i].image4)
              // console.log("★★★ after " + this.dbInputData[i].image5)
            }
          });
    },  // setInputData_placeid
    // map에서 enter Key를 눌렀을 때의 event. (주변 음식점이 db에 등록 됨)
    mapEnter : function() {
      // db에 넣기
      for(var i=0; i<this.dbInputData.length; i++){
        axios.post("/api/map", this.dbInputData[i]).then(res => {
          console.log(res);
        }).catch(err => {
          console.log(err);
        })
      }
    }, // mapEnter


  },  // method()

})
</script>