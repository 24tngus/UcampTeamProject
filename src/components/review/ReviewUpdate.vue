<template>
  <header>Review</header>
  <div v-if="review" id="reviewContainer" class="container" style="margin-left: -3px">
    <form @submit.prevent="reviewUpdate">
      <label></label>
      <textarea name="content" v-model="review.content"
                placeholder="식당을 이용하신 후 자유롭게 의견을 나눠주세요. 음식의 맛, 서비스, 분위기 등을 자세히 기술해주시면 다른 이용자들에게 큰 도움이 됩니다."></textarea>

      <input ref="image" @change="uploadImg()" type="file" id="chooseFile" name="chooseFile" accept="image/*">
      <button type="submit">등록</button>
    </form>
    <div class="review-photo">
      <img :src="getImageUrl(review.image)" v-if="review.image" />
    </div>
  </div>
  <div v-else>
    Loading...
  </div>
</template>

<script>
import axios from "axios";
import router from "@/scripts/router";

export default {
  data() {
    return {
      review: {
        content: '',
        image: ''
      },
    };
  },
  created() {
    this.fetchReview();
  },
  methods: {
    fetchReview() {
      const seq = this.$route.params.value;
      axios
          .get(`/api/review/updateForm/${seq}`)
          .then((response) => {
            this.review = response.data;
          })
          .catch((error) => {
            console.error("리뷰를 불러오는 중 오류 발생", error);
          });
    },
    reviewUpdate() {
      axios
          .put(`/api/review/update/${this.review.seq}`, this.review)
          .then((response) => {
            console.log("리뷰가 성공적으로 업데이트되었습니다", response);
            window.alert("리뷰정보가 수정 되었습니다");
            router.push({path: "/menu"});
          })
          .catch((error) => {
            console.error("리뷰 업데이트 중 오류 발생", error);
          });
    },
    uploadImg() {
      var image = this.$refs["image"].files[0];
      const url = URL.createObjectURL(image);
      this.image = url;
      this.review.image = this.image;
      console.log(url);
      console.log(this.image);
    },
    getImageUrl(imageName) {
      return `/api/images/${imageName}`;
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}

header {
  width: 80%;
  font-size: 2em;
  text-align: center;
  background: #2ecc71;
  color: #fff;
  margin: 0 auto;
  padding: 0.5em;
}

body {
  max-width: 1024px;
  margin: 20px auto;
  font-size: 16px;
  font-family: 'Poppins', sans-serif;
}

img {
  max-width: 100%;
  display: block;
}

p {
  margin: 0;
}

label {
  width: 15%;
  margin: 10px 1% 0 0;
  display: inline-block;
  float: left;
}

input[type="text"] {
  width: 84%;
  margin: 10px 0;
  height: 40px;
  border: none;
  background: #F6F6F6;
  padding: 1em;
}

textarea {
  width: 84%;
  border: none;
  background: #F6F6F6;
  margin: 10px auto;
  height: 100px;
  padding: 1em;
  border-radius: 20px;
  text-align: center;

}

button {
  float: right;
  width: 20%;
  height: 40px;
  border: none;
  background: #2ecc71;
  font-size: 16px;
  color: white;
}

.review {
  width: 100%;
  display: inline-block;
  margin: 10px 0;
}

.review-photo {
  height: 80px;
  width: 80px;
  display: inline-block;
  float: left;
  margin-right: 3em;
}

.review-box {
  float: left;
  display: inline-block;
  width: 87.5%;
  background: #F6F6F6;
  padding: 1.5em;
  position: relative;
}

.review-box:after, .review-box:before {
  right: 100%;
  top: 10%;
  border: solid transparent;
  content: " ";
  height: 0;
  width: 0;
  position: absolute;
  pointer-events: none;
}

.review-box:after {
  border-right-color: #F6F6F6;
  border-width: 25px;
}

.review-comment {
  color: #9A9999;
}

.review-date {
  color: #C7C7C7;
}

.review-author {
  color: #C7C7C7;
}

.review-author strong {
  color: black;
}
</style>