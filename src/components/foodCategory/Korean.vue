<template>
  <div>
    <Header />
    <!--  <h1 v-if="modalVisible">안녕 도완아</h1>-->
    <div class="card shadow-sm" id="cat">
      <div class="card-body">
        <div>
          <h2 class="cattitle">Korean Food</h2>
        </div>
        <div class="list-group" id="catlist">
          <div v-for="(korean, idx) in state.items" :key="idx">
            <div class="list-group-item list-group-item-action" @click="showModal(korean)">
              <div>
                <ModalView v-if="korean.modalVisible">
                  <h1>안녕 도완아</h1>
                  <template v-slot:modalText>
                    <div class="card shadow-sm">
                      <div class="card-body">
                        <p class="card-text">
                          <span><h3 class="shopTitle">{{ korean.storename }}</h3></span><br>
                        <span class="shop1">{{ korean.category }}</span><br>
                        <span class="shop2">{{ korean.location }}</span><br>
                        <span>{{ korean.rating }}</span><br>
                        <span><img :src="setImgUrl(korean.image)" /></span>
                        </p>
                      </div>
                    </div>
                  </template>
                </ModalView>
                <div class="card shadow-sm">
                  <div class="card-body">
                    <p class="card-text">
                      <span><h3 class="shopTitle">{{ korean.storename }}</h3></span><br>
                    <span class="shop1">{{ korean.category }}</span><br>
                    <span class="shop2">{{ korean.location }}</span><br>
                    <span>{{ korean.rating }}</span><br>
                    <span><img :src="setImgUrl(korean.image)" />{{ korean.image }}</span>
                    <span><img src="../../../public/you4.jpeg" />{{ korean.image }}</span>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
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
      console.log(korean.storename);
      console.log(korean.location);
      console.log(korean.rating);
      console.log(korean.image);
    };

    const setImgUrl = (imageName) => {
      return `../../../public/${imageName}`;
    };

    return { state, showModal, setImgUrl };
  },
  data() {
    return {
      modalVisible: false,
    };
  },
  components: { ModalView, Header },
  computed: {},
  methods: {},
};
</script>

<style scoped>
.shop2 {
  color: dimgray;
}

.shopTitle {
  border: 1px solid yellow;
  padding: 0;
}

.shop1 {
  border: 1px solid pink;
  color: cadetblue;
}

#cat {
  border: 1px solid green;
  width: 70%;
  height: auto;
  margin: auto;
}

.cattitle {
  border: 1px solid red;
  padding: 20px;
  font-weight: 700;
}

#catlist {
  border: 1px solid blue;
}
</style>
