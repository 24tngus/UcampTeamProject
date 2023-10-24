<template>
  <div class="form-signin w-100 m-auto">
    <form>
      <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

      <div class="form-floating">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
        <label for="floatingInput">Email address</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Password</label>
      </div>

      <div class="form-check text-start my-3">
        <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
          Remember me
        </label>
      </div>
      <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>

      <!-- 카카오 로그인 -->
      <div>
          <img v-on:click="kakaoLoginBtn" src="/img/kakao_login_medium_narrow.png">
      </div>

      <div class="logoutpage">
        <form action="/login" method="get">
          <button @click="kakaoLogout">Kakao Logout</button>
        </form>
      </div>

      <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
    </form>
  </div>
</template>

<script>
export default {
  name: "LogOutPage",

  methods: {
    kakaoLoginBtn:function(){

      window.Kakao.init('a536c370d613ee0cc23595cfd056bf8a') // Kakao Developers에서 요약 정보 -> JavaScript 키

      if (window.Kakao.Auth.getAccessToken()) {
        window.Kakao.API.request({
          url: '/v1/user/unlink',
          success: function (response) {
            console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })
        window.Kakao.Auth.setAccessToken(undefined)
      }


      window.Kakao.Auth.login({
        success: function () {
          window.Kakao.API.request({
            url: '/v2/user/me',
            data: {
              property_keys: ["kakao_account.email"]
            },
            success: async function (response) {
              console.log(response);
            },
            fail: function (error) {
              console.log(error)
            },
          })
        },
        fail: function (error) {
          console.log(error)
        },
      })
    }, // kakaoLoginBtn


    kakaoLogout() {
      if (window.Kakao.Auth.getAccessToken()) {
        window.Kakao.Auth.logout(function () {
          console.log("Kakao logout success");
          window.location.href = 'http://localhost:3000';
        });
      } else {
        console.log("No Kakao access token found.");
      }
    }, // kakaoLogout



  }, // method

}; // export

</script>



<style scoped>
.form-signin {
  max-width: 330px;
  padding: 1rem;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.test { display:flex; justify-content: center; align-items: center; padding-top: 20px}
.kakao { width: 200px; height:40px; background-color:#fdd101; color:white; display:flex; align-items: center; justify-content: center; cursor:pointer; }

</style>