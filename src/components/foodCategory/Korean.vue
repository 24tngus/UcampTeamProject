<template>
  <Header />
  <div class="card shadow-sm">
    <div class="card-body">
      <div class="list-group">
        <div v-for="(korean, idx) in state.items" :key="idx">
          <a href="#" class="list-group-item list-group-item-action">
            <div class="card shadow-sm">
              <!--           <img :src="korean.image"/>-->
              <div class="card-body">
                <p class="card-text">
                  <span> {{korean.storename}} </span>

                </p>
              </div>
            </div>
          </a>
        </div> <!-- v-for-->
      </div>

    </div>
  </div>
</template>

<script>
import { reactive, onMounted } from "vue";
import axios from "axios";
import Header from "@/components/header/Header.vue";

export default {
  components: {Header},
  setup() {
    const state = reactive({
      items: [],
    });

    onMounted(() => {
      axios.get("/api/shop/categ").then((response) => {
        state.items = response.data;
      });
    });

    return { state };
  },
};

</script>

<style scoped>

</style>
