<template>
  <Header />
  <div id="wrapper">
    <div id="container">
      <div class="tab">
        <router-link to="/mypage"><h1>마이페이지</h1></router-link>
        <div class="buttontab">
          <router-link to="/mypage_info"><button class="tablink">회원 정보</button></router-link>
          <router-link to="/cart"><button class="tablink">찜 목록</button></router-link>
          <router-link to="/reserve_usercheck"><button class="tablink">예약 목록</button></router-link>
          <router-link to="/myreview"><button class="tablink">리뷰 확인</button></router-link>
        </div>
      </div>

      <div id="form-main">
        <div class="online small" id="online">
          <br>
          <h1>{{item.name}}님의 리뷰 등록</h1><br>
        </div>

        <div style="box-sizing: border-box; margin: 0; padding: 0; width: 100%; word-break: break-word; -webkit-font-smoothing: antialiased;">
          <table class="wrapper all-font-sans" width="100%" height="100%" cellpadding="0" cellspacing="0" role="presentation">
            <tr>
              <td align="center" style="padding: 24px;" width="100%">
                <table class="sm-w-full" role="presentation">
                  <tr>
                    <!-- 리뷰 -->
                    <div v-if="review" style="border-style: solid; border-color: lightgray">
                      <td align="left" class="sm-p-20 sm-dui17-b-t" style="border-radius: 2px; padding: 40px; position: relative; box-shadow: 0 10px 15px -3px rgba(0, 0, 0, .1), 0 4px 6px -2px rgba(0, 0, 0, .05); vertical-align: top; z-index: 50;" bgcolor="#ffffff" valign="top">
                        <table width="100%" cellpadding="0" cellspacing="0" role="presentation">
                          <tr>
                            <td width="80%">
                              <h1 class="sm-text-lg all-font-roboto" style="font-weight: 700; color: darkolivegreen; line-height: 100%; margin: 0; margin-bottom: 4px; font-size: 35px;">Review</h1>
                              <p class="sm-text-xs" style="margin: 0; color: #a0aec0; font-size: 14px;">Write a review to the store</p>
                            </td>
                            <td style="text-align: right;" width="20%" align="right">
                              <img src="../../../public/a_vegan17.png" style="text-decoration: none; width: 100%">
                            </td>
                          </tr>
                        </table>
                        <table width="100%" cellpadding="0" cellspacing="0" role="presentation">
                          <tr>
                            <td style="padding-top: 24px; padding-bottom: 24px;">
                              <div style="background-color: #edf2f7; height: 2px; line-height: 2px;">&zwnj;</div>
                            </td>
                          </tr>
                        </table>
                        <div style="line-height: 32px;">&zwnj;</div>
                        <table class="sm-leading-32" style="line-height: 45px; font-size: 14px;" width="100%" cellpadding="0" cellspacing="0" role="presentation">
                          <tr>
                            <td class="sm-inline-block" style="font-size: 15px; color: #718096;" width="50%">가게 이름</td>
                            <td class="sm-inline-block" style="font-size: 20px; font-weight: 600; text-align: right;" width="50%" align="right">{{this.store}}</td>
                          </tr>
                        </table>
                        <table style="line-height: 28px; font-size: 14px;" role="presentation">
                          <tr>
                            <td style="font-size: 15px; color: #718096;" width="50%">별점 입력</td><br><br>
                          </tr>
                          <tr>
                            <td class="star-rating">
                              <input type="radio" id="star1" value="1" v-model="review.star">
                              <img src="../../../public/a_star.png" style="width:7%">
                              &nbsp;&nbsp;&nbsp;&nbsp;
                              <input type="radio" id="star2" value="2" v-model="review.star" style="margin-left:15%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              &nbsp;&nbsp;&nbsp;&nbsp;
                              <input type="radio" id="star3" value="3" v-model="review.star" style="margin-left:15%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              &nbsp;&nbsp;&nbsp;&nbsp;
                              <input type="radio" id="star4" value="4" v-model="review.star" style="margin-left:15%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              &nbsp;&nbsp;&nbsp;&nbsp;
                              <input type="radio" id="star5" value="5" v-model="review.star" style="margin-left:15%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              <img src="../../../public/a_star.png" style="width:7%">
                              &nbsp;&nbsp;&nbsp;&nbsp;
                            </td>
                          </tr>
                          <tr>
                            <td style="font-size: 15px; color: #718096;" width="50%">내용 입력</td><br><br>
                          </tr>
                          <tr>
                            <td style="font-size: 15px; font-weight: 600;">
                              <textarea name="content" v-model="review.content"
                                        placeholder="식당을 이용하신 후 자유롭게 의견을 나눠주세요. 음식의 맛, 서비스, 분위기 등을 자세히 기술해주시면 다른 이용자들에게 큰 도움이 됩니다."
                                        style="width: 200%; height: 200px;">
                              </textarea>
                            </td>
                          </tr>
                        </table>

                        <table width="100%" cellpadding="0" cellspacing="0" role="presentation">
                          <tr>
                            <td style="padding-top: 24px; padding-bottom: 24px;">
                              <div style="background-color: #edf2f7; height: 2px; line-height: 2px;">&zwnj;</div>
                            </td>
                          </tr>
                        </table>
                        <table class="sm-leading-32" style="line-height: 45px; font-size: 14px;" width="100%" cellpadding="0" cellspacing="0" role="presentation">
                          <tr>
                            <td class="sm-inline-block" style="font-size: 15px; color: #718096;" width="50%">사진 입력</td>
                            <td><input type="file" ref="fileInput" accept="image/*" @change="onFileChange" /></td>
                          </tr>
                          <tr>
                            <br>
                            <img v-if="imageURL.length !== 0" :src="imageURL" style="width: 500%; height: 500%"/>
                          </tr>
                        </table>
                        <table width="100%" cellpadding="0" cellspacing="0" role="presentation">
                          <tr>
                            <td style="padding-top: 24px; padding-bottom: 24px;">
                              <div style="background-color: #edf2f7; height: 2px; line-height: 2px;">&zwnj;</div>
                            </td>
                          </tr>
                        </table>
                        <br><br>
                        <div class="button-container">
                          <button type="submit" style="height: 30%; width: 100%; opacity: 0.6" class="double action-button" @click="reviewInsert()">등록</button>
                        </div>
                      </td>
                    </div>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
        </div>
      </div>


    </div>
  </div>
</template>

<script>
import axios from "axios";
import router from "@/scripts/router";
import Header from "@/components/header/Header.vue";

export default {
  components: {Header},
  data() {
    return {
      review: {
        content: '',
        image: '',
        star:'',
      },
      item: Object,
      selectedFile: null,
      imageURL: ""
    };
  },
  created() {
    this.load();
    this.store = this.$route.params.value;
  },
  methods: {
    load() {
      axios.get("/api/user/mypage").then(({ data }) => {
        this.item = data;
      });
    },
    reviewInsert() {
      const storename = this.$route.params.value;
      axios
          .put(`/api/review/insert/${storename}`, this.review)
          .then(() => {
            window.alert("리뷰정보가  입력되었습니다");
            router.push({path: "/myreview"});
          })
          .catch((error) => {
            console.error("리뷰 업데이트 중 오류 발생", error);
          });
    },
    onFileChange() {
      this.selectedFile = this.$refs.fileInput.files[0];
      const formData = new FormData();
      // const name = this.selectedFile.name;
      formData.append("file", this.selectedFile);
      axios.post("/api/images/upload", formData, {headers: {"Content-Type": "multipart/form-data",},}).then((data) => {
        this.review.image = data.data;
        this.downloadImage(data.data);
      });
      // window.open(`/api/images/download/${name}`);
      // this.state.form.storefile = this.selectedFile.name;
    },
    downloadImage(fileId) {
      this.imageURL =`/api/images/download/${fileId}`;
    },
  },
};
</script>

<style scoped>
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Oswald:300,400);
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:700,800&subset=korean');

.star-rating {
  display: flex;
  align-items: center;
  margin: 0 0 0 10%;
}

.star-rating label {
  cursor: pointer;
  width: 7%;
}

.online.small h1{
  font-size: 25px;
  margin-bottom: 40px;
  margin-left: 40px;
}
.online ul{
  min-width: 100%;
  max-width: 100%
}
.online .thumbox .textbox h3{
  font-weight: 900;
  font-size: 14px;
  margin-bottom: 10px;
}
.online .thumbox .textbox p{
  color: #6e6a67;
  font-size: 11px;
}
.online .thumbox .textbox p:first-of-type{
  margin-bottom: 10px;
}
.online .filter{
  width: 100%;
  background: #f1f1f1;
  height: 70px;
  line-height: 70px;
  padding: 0 20px;
  margin-bottom: 30px;
}
.online .filter button{
  border: 1px solid #d4d4d4;
  background: #fff;
  width: 100px;
  padding: 5px;
  margin-right: 10px;
  color: #6e6a67
}
.online .filter span{
  float: right;
  font-size: 11px;
  color: #6e6a67
}
.online .filter span b{
  color: #fa2424;
}
.online ul{
  text-align: center;
  padding: 0 5%;
  max-width: 100%;
  min-width: 600px;
}
.online .thumbox .img a{
  display: inline-block;
  width: 100%;
  height: 100%;
}
.online .thumbox .textbox{
  /*    float: left;*/
  height: 100px;
  width: 100%;
  padding:15px 25px;

}
.online .thumbox .textbox h3{
  font-weight: 900;
  font-size: 14px;
  margin-bottom: 10px;
}
.online .thumbox .textbox p{
  color: #6e6a67;
  font-size: 11px;
}
.online .thumbox .textbox p:first-of-type{
  margin-bottom: 10px;
}
.contain {
  display: flex;
  flex-wrap: wrap; /* 자동 줄 바꿈을 위해 설정 */
  justify-content: space-between; /* figure 요소들을 가로로 균등하게 배치 */

}
*,html,body{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  color: #333;
  font-size: 13px;
  font-family: 'Nanum Gothic', sans-serif, '굴림', 'gulim'
}

#wrapper{
  width: 100%;
}

#num{
  text-align: center;
  margin: 30px 0;
  padding: 40px 0;
  position: relative;
  z-index: 2
}
#num:before{
  content: '';
  position: absolute;
  width: 100%;
  height: 100%;
  top:0px;
  left: 0;
  border-top: 1px solid #d4d4d4;
  z-index: -1
}
#num span{
  display: inline-block;
  border: 1px solid #d4d4d4;
  margin: 0 2px;
  padding: 5px 10px;
  vertical-align: middle;
  cursor: pointer
}
#num span a{
  font-size: 10px;
}
.currentNum{
  background: #32312f!important;
}
.currentNum a{
  color: #fff
}
#num span:hover{
  background: #d4d4d4;
}
#num span:hover a,#num span:hover i{
  color: #fff
}
#wrapper{
  background: #f1f1f1
}
#wrapper header {
  position: relative !important;
  background: #fff!important
}
#wrapper .headerwrap a, #wrapper .user i{
  color: #333
}
#container{
  position: relative;
  max-width: 70%;
  min-width:  880px;
  margin: 0 0 0 10%;
  background: #fff;
}
#container:after{
  content:'';
  display: block;
  clear: both
}
#container > div:not(:first-of-type){
  background: #fff;
  padding: 3% 10% 0 25%;

}
.tab{
  position: absolute;
  left: 0;
  width: 200px;
  height: 100%;
  /*    float: left;*/
  /*    background: pink;*/
  height: 100%;
  /*    position: relative;*/
  padding: 200px 20px 0 20px;
}
.tab:after{
  content: '';
  display: block;
  clear:both
}
button{
  border: none;
  background: none;
  outline: none;
  cursor: pointer;
  width: 100px;
  height: 70px;
}
button.on{
  color: #fa2828;
  font-weight: 900
}
.tab h1{
  position: absolute;
  top: 0;
  left: 0;
  /*    float: left;*/
  height: 150px;
  width: 100%;
  background: darkolivegreen;
  color: #fff;
  font-size: 18px;
  text-align: left;
  padding: 25px
}
.tab button{
  width: 100%;
  text-align: left;
  height: 80px;
  font-size: 14px;
  font-weight: 800;
  position: relative;
  cursor: pointer;
  padding-left: 10px
}
.tab button:hover{
  color: #fa2828;
}
.tab button:after{
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  border-bottom: 1px solid #d4d4d4;
}

.horizontal-container button.double {
  margin-top: -5%;
  margin-left: 10px;
}
.double {
  background-color: darkolivegreen;
  color: white;
  padding: 10px; /* 버튼의 내부 여백을 조절합니다. */
  width: 20%;
  border-radius: 6px;
  font-weight: 700;
  font-size: 15px;
  border: 1px solid white;
  opacity: 0.7;
}
.double:hover {
  background-color: darkolivegreen;
  opacity: 1.0;
}
.button-container {
  display: flex;
  justify-content: space-between; /* 두 버튼을 왼쪽과 오른쪽으로 배치합니다. */
  align-items: center; /* 버튼을 세로 중앙 정렬합니다. */
}
#msform .action-button {
  width: 100px;
  background: darkolivegreen;
  font-weight: bold;
  color: white;
  border: 0 none;
  border-radius: 6px;
  cursor: pointer;
  padding: 10px 5px;
  margin: 10px 0px 10px 5px;
  float: right
}

#msform .action-button:hover,
#msform .action-button:focus {
  background-color: darkolivegreen;
}

#msform .action-button-previous {
  width: 100px;
  background: #616161;
  font-weight: bold;
  color: white;
  border: 0 none;
  border-radius: 6px;
  cursor: pointer;
  padding: 10px 5px;
  margin: 10px 5px 10px 0px;
  float: right
}

#msform .action-button-previous {
  width: 100px;
  background: #616161;
  font-weight: bold;
  color: white;
  border: 0 none;
  border-radius: 6px;
  cursor: pointer;
  padding: 10px 5px;
  margin: 10px 5px 10px 0px;
  float: right
}

#msform .action-button-previous:hover,
#msform .action-button-previous:focus {
  background-color: #000000
}

@media screen {
  img {
    max-width: 100%;
  }
  td,
  th {
    box-sizing: border-box;
  }
  u~div .wrapper {
    min-width: 100vw;
  }
  a[x-apple-data-detectors] {
    color: inherit;
    text-decoration: none;
  }
  .all-font-roboto {
    font-family: Roboto, -apple-system, "Segoe UI", sans-serif !important;
  }
  .all-font-sans {
    font-family: -apple-system, "Segoe UI", sans-serif !important;
  }
}
@media (max-width: 600px) {
  .sm-inline-block {
    display: inline-block !important;
  }
  .sm-hidden {
    display: none !important;
  }
  .sm-leading-32 {
    line-height: 32px !important;
  }
  .sm-p-20 {
    padding: 20px !important;
  }
  .sm-py-12 {
    padding-top: 12px !important;
    padding-bottom: 12px !important;
  }
  .sm-text-center {
    text-align: center !important;
  }
  .sm-text-xs {
    font-size: 12px !important;
  }
  .sm-text-lg {
    font-size: 18px !important;
  }
  .sm-w-1-4 {
    width: 25% !important;
  }
  .sm-w-3-4 {
    width: 75% !important;
  }
  .sm-w-full {
    width: 100% !important;
  }
}
</style>