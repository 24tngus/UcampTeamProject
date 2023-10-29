<template>
  <Header2 />
  <div id="wrapper">
    <div id="container">
      <div class="card shadow-sm" id="cat">
        <div class="card-body" >
          <div><h2 class="cattitle">가게 신규 등록</h2></div>
          <div>
            <ul>
              <hr>
              <div  class="memberform">
                <b></b><br>
                <b>가게 이름</b>
                <div class="input-button-container">
                  <input type="text" placeholder="상호명" id="storename" v-model="state.form.storename" required/>
                  <button class="double" @click="exist(state.form.storename)">중복 확인</button>
                </div>
                <br>
                <b>가게 정보</b><input type="text" placeholder="가게 소개" id="detailinfo" v-model="state.form.detailinfo" /><br>
                <b>카테고리</b><input type="text" placeholder="한식/중식/양식/퓨전/카페" id="category" v-model="state.form.category" /><br>
                <b>가게 위치</b><input type="text" placeholder="주소" id="location" v-model="state.form.location" /><br>
                <b>가게 전화번호</b><input type="text" placeholder="가게 전화번호 (- 없이 입력)" id="phonenumber" v-model="state.form.phonenumber" /><br>
                <b>가게 이미지 파일 첨부</b><input type="file" ref="fileInput" @change="onFileChange" /><br>
                <hr><br><br>
                <button text="button" class="bookbtn" @click="register()">등록</button>
              </div>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import {reactive} from "vue";
import axios from "axios";
import router from "@/scripts/router";
import Header2 from "@/components/header/Header2.vue";

export default {
  name: "ShopInsert",
  components: {Header2},
  methods: {
    onFileChange() {
      this.selectedFile = this.$refs.fileInput.files[0];
      // const name = this.selectedFile.name;
      const formData = new FormData();
      formData.append("file", this.selectedFile);
      axios.post("/api/images/upload", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });
      // window.open(`/api/images/download/${name}`);
      this.state.form.image = this.selectedFile.name;
    }
  },
  data() {
    return {
      selectedFile: null,
    };
  },
  setup() {
    const state = reactive({
      flag: 0,
      form :{
        storename: "",
        detailinfo: "",
        category: "",
        location: "",
        phonenumber: "",
        image: ""
      }
    })

    const exist = (exist) => {
      if (state.form.storename == "") {
        window.alert("가게 이름을 입력해주세요");
        router.push({path: "/shop_insert"});
      } else {
        axios.get(`/api/shop/register/join/${exist}`, ).then((res)=> {
          if (res.data == 0) {
            window.alert("중복된 가게 이름입니다. 지점명을 붙여서 다시 입력해주세요");
          } else {
            window.alert("등록 가능한 가게 입니다");
            state.flag = 1;
          }
          router.push({path: "/shop_insert"});
        })
      }
    }

    const register = () => {
      if (state.form.storename == "") {
        window.alert("가게 이름을 입력해주세요");
        router.push({path: "/shop_insert"});
      } else if (state.flag == 0) {
        window.alert("가게 이름을 중복 검사 해주세요");
        router.push({path: "/shop_insert"});
      } else if (state.form.detailinfo == "") {
        window.alert("가게 상세정보를 입력해주세요");
        router.push({path: "/shop_insert"});
      } else if (state.form.category== "") {
        window.alert("가게 카테고리를 입력해주세요");
        router.push({path: "/shop_insert"});
      } else if (state.form.location == "") {
        window.alert("가게 위치를 입력해주세요");
        router.push({path: "/shop_insert"});
      } else if (state.form.phonenumber == "") {
        window.alert("가게 전화번호를 입력해주세요");
        router.push({path: "/shop_insert"});
      } else if (state.form.image == "") {
        window.alert("가게 이미지 1장 이상은 첨부해주세요");
        router.push({path: "/shop_insert"});
      } else {
        axios.post("/api/shop/register/join", state.form).then(()=> {
          window.alert("가게가 등록 되었습니다");
          router.push({path: "/home_store"});
        })
      }
    }
    return {state, register, exist}
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:700,800&subset=korean');

*,html,body{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  color: #333;
  font-size: 13px;
  font-family: 'Nanum Gothic', sans-serif, '굴림', 'gulim'
}

#wrapper {
  background: #f1f1f1;
}
#container{
  position: relative;
  max-width: 90%;
  min-width: 60%;
  margin: 0 0 0 10%;
}

.form-group {
  display: flex;
  align-items: center; /* 세로 중앙 정렬 */
}

.input-button-container {
  display: flex;
  width: 100%;
  align-items: center; /* 세로 중앙 정렬 */
}

.double {
  background-color: darkolivegreen;
  color: white;
  padding: 15px;
  width: 30%;
  margin-left: 10px;
  margin-bottom: 5px;
  border-radius: 6px;
  font-weight: 700;
  font-size: 15px;
  border : 1px solid white;
}

.datepicker-container {
  width: 40%;
  padding: 30px 0;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.datepicker {
  padding : 20px 5px;
}

.formatDate {
  margin-top: 10px;
}
.fieldbook div{
  display: flex;
  gap:10px;
}
.field{
  gap:10px;
}
.utime {
  display: flex;
  align-items: center;
  padding: 10px;
}

.time {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
}

.time button {
  margin: 0;
}
#timebtn{
  padding : 10px;
  border-radius: 8px;
  border : 3px solid lightgray;
}
.memberform input:not(input[type=radio]){
  border: 1px solid #dadada;
  padding: 15px;
  width: 100%;
  margin-bottom: 5px;
  border-radius: 6px;
}
.memberform{
  padding : 0 30px 30px 30px;
}
.bookbtn{
  background-color: darkolivegreen;
  color: white;
  padding: 15px;
  width: 100%;
  margin-bottom: 5px;
  border-radius: 6px;
  font-weight: 700;
  font-size: 15px;
  border : 1px solid white;
}
#cat{
  width : 60%;
  height : auto;
  margin : auto;
  text-align: left;
}
.cattitle{
  padding : 20px;
  font-weight: 700;
}
</style>