<template>
  <Header />
  <div class="card shadow-sm" id="cat">
    <div class="card-body" >
      <div><h2 class="cattitle">Korean Food</h2></div>
      <div class="list-group" id="catlist">
        <div v-for="(korean, idx) in state.items" :key="idx">
          <div class="list-group-item list-group-item-action" @click="showModal(korean)">
            <ModalView v-if="korean.modalVisible">
              <template v-slot:modalText>
                <div class="card shadow-sm">
                  <div class="card-body">
                    <p class="card-text">
                      <div class="mtext-and-image-container">
                        <div class="mtext-content">
                          <span><h3 class="shopTitle"> {{korean.storename}} </h3></span>
                          <span class="shop1"> {{korean.category}} </span> &nbsp;
                          <span><i class="fa fa-star" aria-hidden="true" style="color: green"></i>{{korean.rating}} </span><br>
                          <span>{{korean.phonenumber}}</span><br>
                          <span>{{korean.detailinfo}}</span><br>
                          <span class="shop2"> {{korean.location}} </span>
                        </div>
                        <div class="mimage-content">
                          <img :src="setImgUrl(korean.image)" class="mimglist" />
                        </div>

                        <div>
                          <div><img :src="setImgUrl(korean.image1)" class="ming" /></div>
                          <div><img :src="setImgUrl(korean.image2)" class="ming" /></div>
                          <div><img :src="setImgUrl(korean.image3)" class="ming" /></div>
                          <div><img :src="setImgUrl(korean.image4)" class="ming" /></div>
                          <div><img :src="setImgUrl(korean.image5)" class="ming" /></div>
                        </div>

                      </div>
                    </p>
                  </div>
                </div>
              </template>
            </ModalView>
            <div class="card-body">
              <p class="card-text">
                <div class="text-and-image-container">
                  <div class="text-content">
                    <span><h3 class="shopTitle"> {{korean.storename}} </h3></span>
                    <span class="shop1"> {{korean.category}} </span> &nbsp;
                    <span><i class="fa fa-star" aria-hidden="true" style="color: green"></i>{{korean.rating}} </span><br>
                    <span class="shop2"> {{korean.location}} </span>
                  </div>
                  <div class="image-content">
                    <img :src="setImgUrl(korean.image)" class="imglist" />
                  </div>
                </div>

              </p>
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
    };

    const setImgUrl = (imageName) => {
      return require(`../../../public/${imageName}`);
    };

    return { state, showModal, setImgUrl };
  },
  data() {
    return {
      modalVisible : false
    }
  },
  components: {ModalView, Header},
  computed: {
  },
  methods: {
  }
};

</script>

<style scoped>
.mimglist {
  width: 255px;
  height: 170px;
}
.mtext-and-image-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.mtext-content {
  flex: 1; /* 텍스트 컨테이너가 남은 공간을 차지 */
}

.mimage-content {
  flex: 1; /* 이미지 컨테이너가 남은 공간을 차지 */
  display: flex;
  justify-content: flex-end; /* 이미지를 오른쪽 정렬 */
}
.ming {
  display: inline-block; /* 이미지를 가로로 나열 */
  width: 100px; /* 이미지의 너비를 원하는 크기로 조정 */
  height: 100px; /* 이미지의 높이를 원하는 크기로 조정 */
  margin-right: 10px; /* 이미지 간의 오른쪽 간격을 설정 (원하는 간격으로 조절) */
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