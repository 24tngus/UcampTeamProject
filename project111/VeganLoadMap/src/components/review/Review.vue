<template>
  <header>Review</header>
  <div id="reviewContainer" class="container" style="margin-left: -3px">
    <div v-for="review in reviews" :key="review.seq" class="review">
      <input type="hidden" v-model="review.seq"/>
      <input type="hidden" v-model="review.storeid"/>

      <div class="review-photo">
        <img v-bind:src="review.image">
      </div>

      <div class="review-box">

        <div class="review-author">
          <p><strong>{{ review.writer }} &nbsp;</strong>
            <template v-if="review.star === 1">
              <i class="fa fa-star" aria-hidden="true"></i>
            </template>
            <template v-else-if="review.star === 2">
              <i class="fa fa-star" aria-hidden="true"></i>
              <i class="fa fa-star" aria-hidden="true"></i>
            </template>
            <template v-else-if="review.star === 3">
              <i class="fa fa-star" aria-hidden="true"></i>
              <i class="fa fa-star" aria-hidden="true"></i>
              <i class="fa fa-star" aria-hidden="true"></i>
            </template>
            <template v-else-if="review.star === 4">
              <i class="fa fa-star" aria-hidden="true"></i>
              <i class="fa fa-star" aria-hidden="true"></i>
              <i class="fa fa-star" aria-hidden="true"></i>
              <i class="fa fa-star" aria-hidden="true"></i>
            </template>
            <template v-else-if="review.star === 5">
              <i class="fa fa-star" aria-hidden="true"></i>
              <i class="fa fa-star" aria-hidden="true"></i>
              <i class="fa fa-star" aria-hidden="true"></i>
              <i class="fa fa-star" aria-hidden="true"></i>
              <i class="fa fa-star" aria-hidden="true"></i>
            </template>
          </p>
        </div>

        <div class="review-comment">
          <p>{{ review.content }}</p>
        </div>
      </div>
      <router-link :to="{ name: 'review_update', params: { value: review.seq } }"><button v-if="review.writer === nickname" type="button">수정</button></router-link>

      <button v-if="review.writer === nickname" type="button" @click="deleteReview(review)">삭제</button>
    </div>

  </div>
</template>
<script>
import axios from 'axios';

export default {
  data() {
    return {
      reviews: [],
      nickname: '',
      newReview: {
        seq: '',
        storeid: '',
        content: '',
        image: '',
      },

    };
  },
  created() {
    this.fetchReview();
  },
  methods: {
    fetchReview() {
      const storename = this.$route.query.storename;
      axios
          .get("/api/review/list", {
            params: {
              storename: storename // 이 부분에서 해당 데이터를 전달합니다.
            }
          })
          .then((response) => {
            this.reviews = response.data.reviewList;
            this.nickname = response.data.nickname;
          })
          .catch((error) => {
            console.error("Error fetching reviews", error);
          });
    },uploadImg() {
      var image = this.$refs['image'].files[0]
      const url = URL.createObjectURL(image)
      this.image = url
      this.newReview.image = this.image;
      console.log(url)
      console.log(this.image)
    },
    addReview() {
      axios
          .post("/api/review/insert", this.newReview)
          .then((response) => {
            console.log("Review added successfully", response);
            this.fetchReview(); // Fetch reviews again to get the updated list
            this.newReview = {
              storeid: '',
              content: '',
              image: '',
            };
            alert("리뷰가 등록되었습니다.");
          })
          .catch((error) => {
            console.error("Error adding review", error);
          });
    },
    deleteReview(review) {
      axios
          .delete(`/api/review/delete/${review.seq}`) // Assuming seq is the identifier for the review
          .then(() => {
            this.fetchReview();
          })
          .catch((error) => {
            console.error("Error delete review", error);
          });
    },
  },
};
</script>
<style scoped>
* {
  box-sizing: border-box;
}
.fa.fa-star{
  color:#FEC902;
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