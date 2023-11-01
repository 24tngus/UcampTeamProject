<template>
  <Header2 />
  <section class="showcase-area" id="showcase">
    <div class="background-image" :style="'background-image: url(/aaa1.png)'"></div>
    <div class="showcase-container">
      <div class="main-title" id="home">Store registration</div><br>
<!--      <p class="p-title">내 가게 등록</p>-->
<!--      <a href="/shop_insert2" class="btn btn-primary">시작하기</a>-->
    </div>
  </section>
  <div class="container-fluid">
    <div class="row justify-content-center">
      <div class="col-11 col-sm-10 col-md-10 col-lg-6 col-xl-5 text-center p-0 mt-3 mb-2">
        <div class="card px-0 pt-4 pb-0 mt-3 mb-3">
          <h2 id="heading">가게 등록</h2><br><br>
          <p>가게를 등록하면 VeganLoadMap에서 예약 서비스를 이용하실 수 있습니다.</p><br><br>
          <div id="msform">

            <!-- fieldsets -->
            <fieldset v-if="flag === 1">
              <ul id="progressbar">
                <li class="active" id="account"><strong>Name</strong></li>
                <li id="personal"><strong>Information</strong></li>
                <li id="payment"><strong>Image</strong></li>
                <li id="confirm"><strong>Menu</strong></li>
              </ul><br>
              <div class="form-card">
                <div class="row">
                  <div class="col-7">
                    <h2 class="fs-title">가게 정보 입력 :</h2>
                  </div>
                  <div class="col-5">
                    <h2 class="steps">1/4</h2>
                  </div>
                </div> <br>
                <label class="fieldlabels">가게 이름 : *</label>
                <div class="horizontal-container">
                  <input type="text" placeholder="상호명" id="storename" v-model="state.form.storename" required />
                  <button class="double" @click="exist(state.form.storename)">중복 확인</button><br>
                </div>

                <label class="fieldlabels">가게 정보 : *</label>
                <input type="text" placeholder="가게 소개" id="detailinfo" v-model="state.form.detailinfo" style="height: 150px;"/>

              </div> <input type="button" @click="next" name="next" class="double action-button" value="Next" />
            </fieldset>

            <fieldset v-if="this.flag === 2">
              <ul id="progressbar">
                <li class="active" id="account"><strong>Name</strong></li>
                <li id="personal"><strong>Information</strong></li>
                <li id="payment"><strong>Image</strong></li>
                <li id="confirm"><strong>Menu</strong></li>
              </ul><br>
              <div class="form-card">
                <div class="row">
                  <div class="col-7">
                    <h2 class="fs-title">가게 상세 정보 입력 :</h2>
                  </div><br>
                  <div class="col-5">
                    <h2 class="steps">2/4</h2>
                  </div>
                </div>
                <label class="fieldlabels">카테고리 : *</label>
                <input type="text" placeholder="한식/중식/양식/퓨전/카페" id="category" v-model="state.form.category" />
                <label class="fieldlabels">가게 위치 : *</label>
                <input type="text" placeholder="주소" id="location" v-model="state.form.location" style="height: 100px;"/>
                <label class="fieldlabels">가게 전화번호 : *</label>
                <input type="text" placeholder="가게 전화번호" id="phonenumber" v-model="state.form.phonenumber" />
              </div> <input type="button" @click="next" name="next" class="action-button" value="Next" />
              <input type="button" @click="previous" name="previous" class="previous action-button-previous" value="Previous" />
            </fieldset>

            <fieldset v-if="this.flag === 3">
              <ul id="progressbar">
                <li class="active" id="account"><strong>Name</strong></li>
                <li id="personal"><strong>Information</strong></li>
                <li id="payment"><strong>Image</strong></li>
                <li id="confirm"><strong>Menu</strong></li>
              </ul><br>
              <div class="form-card">
                <div class="row">
                  <div class="col-7">
                    <h2 class="fs-title">Image Upload:</h2>
                  </div><br>
                  <div class="col-5">
                    <h2 class="steps">3/4</h2>
                  </div>
                </div>
                <label class="fieldlabels">가게 이미지 첨부 :</label>
                <input type="file" ref="fileInput1" accept="image/*" @change="onFileChange1" />
                <img v-if="imageURL1 !== 0"  :src="imageURL1" style="width: 100%"/>
                <input type="file" ref="fileInput2" accept="image/*" @change="onFileChange2" />
                <img v-if="imageURL2 !== 0"  :src="imageURL2" style="width: 100%"/>
                <input type="file" ref="fileInput3" accept="image/*" @change="onFileChange3" />
                <img v-if="imageURL3 !== 0"  :src="imageURL3" style="width: 100%"/>
              </div> <input type="button" @click="next" name="next" class="action-button" value="Next" />
              <input type="button" @click="previous" name="previous" class="previous action-button-previous" value="Previous" />
            </fieldset>

            <fieldset v-if="this.flag === 4">
              <ul id="progressbar">
                <li class="active" id="account"><strong>Name</strong></li>
                <li id="personal"><strong>Information</strong></li>
                <li id="payment"><strong>Image</strong></li>
                <li id="confirm"><strong>Menu</strong></li>
              </ul><br>
              <div class="form-card">
                <div class="row">
                  <div class="col-7">
                    <h2 class="fs-title">Finish :</h2>
                  </div>
                  <div class="col-5">
                    <h2 class="steps">4/4</h2>
                  </div>
                </div> <br><br>
                <h2 class="purple-text text-center"><strong>입점 신청 완료</strong></h2> <br>
                <div class="row justify-content-left">
                  <div class="col-3"> <img src="https://i.postimg.cc/sD5yZMJk/a-vegan2.png" style="width: 200%; margin-left: 120%"> </div>
                </div> <br><br>
                <div class="row justify-content-center">
                  <div class="col-7 text-center">
                    <h5 class="purple-text text-center">영업일 기준 3일 이내 입점 승인 결과를 메일로 안내해드립니다.</h5>
                  </div>
                </div>
              </div>
            </fieldset>

          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Header2 from "@/components/header/Header2.vue";
import axios from "axios";
import {reactive} from "vue";
import router from "@/scripts/router";

export default {
  components: {Header2},
  methods: {
    onFileChange1() {
      this.selectedFile = this.$refs.fileInput1.files[0];
      const formData = new FormData();
      // const name = this.selectedFile.name;
      formData.append("file", this.selectedFile);
      axios.post("/api/images/upload", formData, {headers: {"Content-Type": "multipart/form-data",},}).then((data) => {
        this.state.form.image = data.data;
        this.downloadImage1(data.data);
      });
    },
    downloadImage1(fileId) {
      this.imageURL1 =`/api/images/download/${fileId}`;
    },
    onFileChange2() {
      this.selectedFile = this.$refs.fileInput2.files[0];
      const formData = new FormData();
      // const name = this.selectedFile.name;
      formData.append("file", this.selectedFile);
      axios.post("/api/images/upload", formData, {headers: {"Content-Type": "multipart/form-data",},}).then((data) => {
        this.state.form.image2 = data.data;
        this.downloadImage2(data.data);
      });
    },
    downloadImage2(fileId) {
      this.imageURL2 =`/api/images/download/${fileId}`;
    },
    onFileChange3() {
      this.selectedFile = this.$refs.fileInput3.files[0];
      const formData = new FormData();
      // const name = this.selectedFile.name;
      formData.append("file", this.selectedFile);
      axios.post("/api/images/upload", formData, {headers: {"Content-Type": "multipart/form-data",},}).then((data) => {
        this.state.form.image3 = data.data;
        this.downloadImage3(data.data);
      });
    },
    downloadImage3(fileId) {
      this.imageURL3 =`/api/images/download/${fileId}`;
    },
    next() {
      if (this.flag === 1) {
        if (this.state.form.storename == "") {
          window.alert("가게 이름을 입력해주세요");
        } else if (this.state.flag == 0) {
          window.alert("가게 이름을 중복 검사 해주세요");
        }
        if (this.state.form.detailinfo == "") {
          window.alert("가게 상세정보를 입력해주세요");
        } else {
          this.flag = this.flag + 1;
        }
      } else if (this.flag === 2) {
        if (this.state.form.category== "") {
          window.alert("가게 카테고리를 입력해주세요");
        } else if (this.state.form.location == "") {
          window.alert("가게 위치를 입력해주세요");
        } else if (this.state.form.phonenumber == "") {
          window.alert("가게 전화번호를 입력해주세요");
        } else {
          this.flag = this.flag + 1;
        }
      } else if (this.flag === 3) {
        if (this.state.form.image1 == "" && this.state.form.image2 == "" && this.state.form.image3 == "") {
          window.alert("가게 이미지 3장 첨부해주세요");
        } else {
          this.flag = this.flag + 1;
        }
        this.register();
      }
    },
    previous() {
      if (this.flag > 1) {
        this.flag--;
      }
    }
  },
  data() {
    return {
      selectedFile: null,
      imageURL1: "",
      imageURL2: "",
      imageURL3: "",
      flag: 1
    };
  },
  setup() {
    const state = reactive({
      flag: 0,
      // i : 0,
      form :{
        storename: "",
        detailinfo: "",
        category: "",
        location: "",
        phonenumber: "",
        image: "",
        image2: "",
        image3: ""
      },
    })

    const exist = (exist) => {
      if (state.form.storename == "") {
        window.alert("가게 이름을 입력해주세요");
      } else {
        axios.get(`/api/shop/register/join/${exist}`, ).then((res)=> {
          if (res.data == 0) {
            window.alert("중복된 가게 이름입니다. 지점명을 붙여서 다시 입력해주세요");
          } else {
            window.alert("등록 가능한 가게 입니다");
            state.flag = 1;
          }
        })
      }
    }

    const register = () => {
      axios.post("/api/shop/register/join", state.form).then(()=> {
        window.alert("가게가 등록 되었습니다");
        router.push({path: "/home_store"});
      })
    }

    return {state, register, exist}
  }
}
</script>

<style scoped>
.horizontal-container {
  display: flex;
  align-items: center; /* 수직 가운데 정렬이 필요한 경우 추가 */
}

.horizontal-container input[type="text"] {
  width: 200px; /* 예시 폭 */
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
  margin-left: 10px;
  border-radius: 6px;
  font-weight: 700;
  font-size: 15px;
  border: 1px solid white;
}

* {
  margin: 0;
  padding: 0
}

html {
  height: 100%
}

p {
  color: grey
}

#heading {
  font-size: 200%;
  text-transform: uppercase;
  color: darkolivegreen;
  font-weight: normal
}

#msform {
  text-align: center;
  position: relative;
  margin-top: 20px
}

#msform fieldset {
  background: white;
  border: 0 none;
  border-radius: 0.5rem;
  box-sizing: border-box;
  width: 100%;
  margin: 0;
  padding-bottom: 20px;
  position: relative
}

.form-card {
  text-align: left
}

#msform fieldset:not(:first-of-type) {
  display: none
}

#msform input,
#msform textarea {
  padding: 8px 15px 8px 15px;
  border: 1px solid #ccc;
  border-radius: 0px;
  margin-bottom: 25px;
  margin-top: 2px;
  width: 100%;
  box-sizing: border-box;
  font-family: montserrat;
  color: #2C3E50;
  background-color: #ECEFF1;
  font-size: 16px;
  letter-spacing: 1px
}

#msform input:focus,
#msform textarea:focus {
  -moz-box-shadow: none !important;
  -webkit-box-shadow: none !important;
  box-shadow: none !important;
  border: 1px solid darkolivegreen;
  outline-width: 0
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

#msform .action-button-previous:hover,
#msform .action-button-previous:focus {
  background-color: #000000
}

.card {
  z-index: 0;
  border: none;
  position: relative
}

.fs-title {
  font-size: 25px;
  color: darkolivegreen;
  margin-bottom: 15px;
  font-weight: normal;
  text-align: left
}

.purple-text {
  color: darkolivegreen;
  font-weight: normal
}

.steps {
  font-size: 25px;
  margin-bottom: 10px;
  font-weight: normal;
  text-align: right
}

.fieldlabels {
  text-align: left
}

#progressbar {
  margin-bottom: 30px;
  overflow: hidden;
  color: lightgrey
}

#progressbar .active {
  color: darkolivegreen;
}

#progressbar li {
  list-style-type: none;
  font-size: 15px;
  width: 25%;
  float: left;
  position: relative;
  font-weight: 400
}

#progressbar li:before {
  width: 50px;
  height: 50px;
  line-height: 45px;
  display: block;
  font-size: 20px;
  color: #ffffff;
  background: lightgray;
  border-radius: 50%;
  margin: 0 auto 10px auto;
  padding: 2px
}

.progress {
  height: 20px
}

/* 진행 아이콘 부분 */
#progressbar #account:before {
  font-family: FontAwesome;
  content: "✏️"
}
#progressbar #personal:before {
  font-family: FontAwesome;
  content: "🗒️"
}
#progressbar #payment:before {
  font-family: FontAwesome;
  content: "📷"
}
#progressbar #confirm:before {
  font-family: FontAwesome;
  content: "✔️"
}
#progressbar li.active:before,
#progressbar li.active:after {
  background: darkolivegreen;
}
.fit-image {
  width: 100%;
  object-fit: cover
}

@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");
*,html,body{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  color: #333;
  font-size: 13px;
  font-family: 'Nanum Gothic', sans-serif, '굴림', 'gulim'
}

body {
  font-family: "Poppins", sans-serif;
}
.showcase-area {
  height: 20vh;
  background: linear-gradient(
      rgba(240, 240, 240, 0.144),
      rgba(255, 255, 255, 0.336)
  ),
  url("https://i.postimg.cc/vmFX9mvj/6.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}
.showcase-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
  font-size: 1.6rem;
}
.main-title {
  font-size: 180%;
  margin-top: 5%;
  color: #545d32;
}
.p-title {
  font-size: 80%;
  color: #6e6a67;
}
btn {
  display: inline-block;
  padding: 0.5em 1.5em;
  text-decoration: none;
  border-radius: 50px;
  cursor: pointer;
  outline: none;
  margin-top: 1em;
  text-transform: uppercase;
}
.btn-primary {
  color: #fff;
  background: darkolivegreen;
  width: 15%;
  opacity: 0.7; /* 투명도를 조정합니다. 0.0에서 1.0까지 가능합니다. */
  transition: opacity 0.3s ease-in-out;
}
.btn-primary:hover {
  background: darkolivegreen;
  transition: background 0.3s ease-in-out;
  opacity: 1.0;
}
</style>