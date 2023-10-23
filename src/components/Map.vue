<template>
  <GoogleMap
      api-key="AIzaSyB21eMRg-uMRk-i7r27DPDkntXbR5_kvnk"
      style="width: 100%; height: 500px"
      :center="center"
      :zoom="15"
      language="kor"
  >
    <MarkerCluster>
      <Marker v-for="(location, i) in locations" :options="{ position: location }" :key="i"
              @click="showPlaceInfo()">
        <InfoWindow>  <!-- Marker 클릭하면 나오는 부분 -->
          <div id="contet">
            <div id="siteNotice"></div>
            <h1 id="firstHeading" class="firstHeading" v-if="detailPlaceInfo">{{ this.detailPlaceInfo.name }}</h1> <!-- 가게 이름 -->
            <div id="bodyContent">
              <p v-if="detailPlaceInfo">  <!-- 도로명 주소 -->
                {{ this.detailPlaceInfo.formatted_address }}
              </p>
              <p v-if="detailPlaceInfo">  <!-- 도로명 주소 -->
                {{ this.detailPlaceInfo.rating }}
              </p>
<!--              <div>-->
<!--                <img src="../../public/img/bread.jpg" style="width: 100px">-->
<!--              </div>-->

            </div>
          </div>
        </InfoWindow>
      </Marker>
    </MarkerCluster>
  </GoogleMap>
</template>

<script>
import {defineComponent} from 'vue'
import {GoogleMap, Marker, MarkerCluster, InfoWindow} from 'vue3-google-map'
// import {error} from "@babel/eslint-parser/lib/convert";

export default defineComponent({
  components: {GoogleMap, Marker, MarkerCluster, InfoWindow},
  setup() {
    const mapCenter = {lat: 37.5593773, lng: 126.832661}

    const locations = [
      {lat: 37.5593773, lng: 126.832661},
      {lat: 37.55795, lng: 126.8397055},
    ]

    return {mapCenter, locations}
  },  // setup()
  data() {
    return {
      center : null,
      jsonData : null,
      detailPlaceInfo : null,
    };
  },  // data()
  async mounted() {
    let parseJsonData;

    try {
      this.center = await this.getUserLocation();

    } catch (error) {
      console.log("Error User Location : " + error);
    }

    fetch('https://proxy.cors.sh/https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=37.561736,%20126.835419&rankby=distance&name=%EC%82%BC%EA%B2%B9%EC%82%B4&key=AIzaSyB21eMRg-uMRk-i7r27DPDkntXbR5_kvnk', {
      headers: {
        'x-cors-api-key': 'temp_924d232f48d59dabc25af9778ab72f25'
      }
    })
        .then(res => res.json())
        .then(res => {
          parseJsonData = res;
          this.jsonData = parseJsonData.results;
          console.log(this.jsonData);
          console.log(this.jsonData[1].name);
        });
  },  // mounted()
  methods: {
    showPlaceInfo: function () {  // place_id로 googleMap JSON Data를 Parsing
      fetch('https://proxy.cors.sh/https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJP1CJmGGcfDUR7ffziy-8NZA&key=AIzaSyB21eMRg-uMRk-i7r27DPDkntXbR5_kvnk', {
        headers: {
          'x-cors-api-key': 'temp_924d232f48d59dabc25af9778ab72f25'
        }
      })
          .then(res => res.json())
          .then(res => {
            this.detailPlaceInfo = res.result;
            console.log(this.detailPlaceInfo.name);
            console.log(this.detailPlaceInfo.place_id);
            console.log(this.detailPlaceInfo.geometry.location.lat);
            console.log(this.detailPlaceInfo.geometry.location.lng);
          })
    },  // showPlaceInfo
    getUserLocation: function () {  // User의 현재 위치 가져오기
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
    } // getUserLocation
  },  // method()
})
</script>