<template>
  <Header />
  <div class="card shadow-sm" id="cat">
    <div class="card-body" >
      <div><h2 class="cattitle">Korean Food</h2></div>
      <div class="list-group" id="catlist">
        <select @change="sortByRating">
          <option value="ascending">평점 낮은 순</option>
          <option value="descending">평점 높은 순</option>
        </select>
        <div v-for="(korean, idx) in sortedItems" :key="idx">
          <div class="list-group-item list-group-item-action" @click="showModal(korean)">
            <ModalView v-if="korean.modalVisible">
              <template v-slot:modalText>
                <div class="card shadow-sm">
                  <div class="card-body">
                    <div class="mtext-and-image-container">
                      <div class="mdetails">
                        <div class="mtext-content">
                          <span><h3 class="shopTitle"> {{korean.storename}} </h3></span>
                          <span class="shop1"> {{korean.category}} </span> &nbsp;
                          <span><i class="fa fa-star" aria-hidden="true" style="color: green"></i>&nbsp;{{korean.rating}} </span><br>
                          <span><i class="fa fa-phone" aria-hidden="true"></i>&nbsp;{{korean.phonenumber}}</span><br>
                          <span><i class="fa fa-clock-o" aria-hidden="true"></i>&nbsp;{{korean.detailinfo}}</span><br>
                          <span class="shop2"><i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp; {{korean.location}} </span>
                        </div>
                        <div class="mimage-content">
                          <img :src="setImgUrl(korean.image)" class="mimglist" style="width: 300px; height: 220px;"/>
                        </div>
                      </div>

                      <div class="anotherimage">
                        <div><img :src="setImgUrl(korean.image1)" class="ming" /></div>
                        <div><img :src="setImgUrl(korean.image2)" class="ming" /></div>
                        <div><img :src="setImgUrl(korean.image3)" class="ming" /></div>
                        <div><img :src="setImgUrl(korean.image4)" class="ming" /></div>
                        <div><img :src="setImgUrl(korean.image5)" class="ming" /></div>
                      </div>

                    </div>
                  </div>
                </div>
              </template>
            </ModalView>
            <div class="card-body">
              <div class="text-and-image-container">
                <div class="text-content">
                  <span><h3 class="shopTitle"> {{korean.storename}} </h3></span>
                  <span class="shop1"> {{korean.category}} </span> &nbsp;
                  <span><i class="fa fa-star" aria-hidden="true" style="color: green"></i>{{korean.rating}} </span><br>
                  <span class="shop2"> <i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp;{{korean.location}} </span>
                </div>
                <div class="image-content">
                  <img :src="setImgUrl(korean.image)" class="imglist" />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div> <!-- v-for-->
    </div>

  </div>
</template>

<script>
import { reactive, onMounted } from "vue";
import axios from "axios";
import Header from "@/components/header/Header.vue";
import ModalView from "@/components/foodCategory/ModalView.vue";

export default {
  setup() {
    const state = reactive({
      items: [],
    });

    onMounted(() => {
      axios.get("/api/shop/korean").then((response) => {
        state.items = response.data;
      });
    });

    const showModal = (korean) => {
      korean.modalVisible = !korean.modalVisible;
      console.log(korean.storename)
      console.log(korean.location)
      console.log(korean.rating)
      console.log(korean.image)
      console.log(korean.image1)
      console.log(korean.image2)
      console.log(korean.image3)
      console.log(korean.image4)
      console.log(korean.image5)
    };

    const setImgUrl = (imageName) => {
      return require(`../../../public/${imageName}`);
    };

    return { state, showModal, setImgUrl };
  },
  data() {
    return {
      modalVisible : false,
      sortOrder : "ascending",
    };
  },
  components: {ModalView, Header},
  computed: {
    sortedItems() {
      if (this.sortOrder === "ascending") {
        return this.state.items.slice().sort((a, b) => a.rating - b.rating);
      } else if (this.sortOrder === "descending") {
        return this.state.items.slice().sort((a, b) => b.rating - a.rating);
      } else {
        return this.items;
      }
    },
  },
  methods: {
    sortByRating(event) {
      this.sortOrder = event.target.value;
    },
  },
};

</script>

<style scoped>

.mimglist:hover{
  transform: scale(1.4); /* 이미지 크기를 1.2배로 확대 */
  transition: transform 0.3s; /* 변환 효과에 0.3초 동안의 트랜지션 적용 */
}
.ming:hover{
  transform: scale(3); /* 이미지 크기를 1.2배로 확대 */
  transition: transform 0.3s; /* 변환 효과에 0.3초 동안의 트랜지션 적용 */
}
/* 기존 스타일 유지 */
.mtext-and-image-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-direction: column;
}

.mtext-content {
  flex: 1;
  text-align: left;
  width : 700px;
  height : auto;
  padding : 20px;
  margin: 20px 0 20px 0 ;
}

.mimage-content {
  flex: 1;
  display: flex;
  justify-content: flex-end;
}

.ming {
  display: inline-block;
  width: 100px;
  height: 100px;
  margin-right: 10px;
}

/* .mdetails와 .anotherimage 영역 분리 */

.mdetails {
  display: flex;
  align-items: center; /* 수직 중앙 정렬 */
}

.mtext-content {
  flex: 1; /* 텍스트 컨테이너가 남은 공간을 차지 */
}

.mimage-content {
  position: relative;
}

.mimglist {
  max-width: 100%; /* 이미지의 최대 너비를 부모 컨테이너에 맞게 설정 */
  height: auto; /* 높이를 자동으로 조절하여 가로세로 비율 유지 */
  position: absolute; /* 절대 위치로 설정 */
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto; /* 가운데 정렬 */
}

.anotherimage {
  display: flex;
  justify-content: center;
  align-items: center;
}
.card-body {
  padding: 10px;
}

.text-and-image-container {
  display: flex;
  align-items: center;
}

.text-content {
  flex: 1;
}

.image-content {
  flex: 0;
  margin-left: 10px;
}
.imglist {
  width: 255px;
  height: 170px;
}

.shop2{
  color : dimgray;
}

.shopTitle{
  padding : 10px;
}

.shop1{
  color : cadetblue;
  font-weight: 600;
}
#cat{
  width : 70%;
  height : auto;
  margin : auto;
}

.cattitle{
  padding : 20px;
  font-weight: 700;
}

#catlist{
  width : 80%;
  text-align: center;
  margin : auto;
}

</style>