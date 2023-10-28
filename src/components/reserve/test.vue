<template>

  <main>
    <div class="calendar">
      <div class="month-indicator">
        <time datetime="2019-07"> July 2019 </time>
      </div>
      <div class="day-of-week">
        <div>Su</div>
        <div>Mo</div>
        <div>Tu</div>
        <div>We</div>
        <div>Th</div>
        <div>Fr</div>
        <div>Sa</div>
      </div>
      <div class="date-grid">
        <button>
          <time datetime="2019-02-01">1</time>
        </button>
        <button>
          <time datetime="2019-02-02">2</time>
        </button>
        <button>
          <time datetime="2019-02-03">3</time>
        </button>
        <button>
          <time datetime="2019-02-04">4</time>
        </button>
        <button>
          <time datetime="2019-02-05">5</time>
        </button>
        <button>
          <time datetime="2019-02-06">6</time>
        </button>
        <button>
          <time datetime="2019-02-07">7</time>
        </button>
        <button>
          <time datetime="2019-02-08">8</time>
        </button>
        <button>
          <time datetime="2019-02-09">9</time>
        </button>
        <button>
          <time datetime="2019-02-10">10</time>
        </button>
        <button>
          <time datetime="2019-02-11">11</time>
        </button>
        <button>
          <time datetime="2019-02-12">12</time>
        </button>
        <button>
          <time datetime="2019-02-13">13</time>
        </button>
        <button>
          <time datetime="2019-02-14">14</time>
        </button>
        <button>
          <time datetime="2019-02-15">15</time>
        </button>
        <button>
          <time datetime="2019-02-16">16</time>
        </button>
        <button>
          <time datetime="2019-02-17">17</time>
        </button>
        <button>
          <time datetime="2019-02-18">18</time>
        </button>
        <button>
          <time datetime="2019-02-19">19</time>
        </button>
        <button>
          <time datetime="2019-02-20">20</time>
        </button>
        <button>
          <time datetime="2019-02-21">21</time>
        </button>
        <button>
          <time datetime="2019-02-22">22</time>
        </button>
        <button>
          <time datetime="2019-02-23">23</time>
        </button>
        <button>
          <time datetime="2019-02-24">24</time>
        </button>
        <button>
          <time datetime="2019-02-25">25</time>
        </button>
        <button>
          <time datetime="2019-02-26">26</time>
        </button>
        <button>
          <time datetime="2019-02-27">27</time>
        </button>
        <button>
          <time datetime="2019-02-28">28</time>
        </button>
        <button>
          <time datetime="2019-02-28">29</time>
        </button>
        <button>
          <time datetime="2019-02-28">30</time>
        </button>
        <button>
          <time datetime="2019-02-28">31</time>
        </button>

      </div>
    </div>
  </main>

</template>

<script>
export default {

};
</script>

<style scoped>
body {
  font-family: "Roboto", "Helvetica", "Arial", sans-serif;
  background:#d9e2eb;
  height: 100vh;
  display:flex;
  align-items: center;
  justify-content: center;
  padding: 0;
  margin: 0;
}
main {
  max-width: max-content;
  box-shadow: 0 2px 20px rgba(0, 0, 0, 0.1);
}
.calendar {
  background:white;
  border:2px solid #bdccdb;
  border-radius:7px;
  padding:4em
}
.day-of-week,
.date-grid {
  display: grid;
  grid-template-columns: repeat(7, 1fr);
}
/* For the month */
.month-indicator {
  font-size:2em;
  color: #334e68;
  text-align: center;
  font-weight: 500;
}
/* Styles for the weekday/weekend header */
.day-of-week {
  background:whitesmoke;
  margin: 2em 0;
  font-size: 0.7em;
  letter-spacing: 0.1em;
  font-variant: small-caps;
  text-align: center;
}
/* Dates */
.date-grid {
  margin-top: 0.5em;
}
/* Positioning the first day, according to month */
.date-grid button:first-child {
  grid-column: 2;
}
.date-grid button {
  font-size:1em;
  position: relative;
  width:50px;
  height:50px;
  border: 0;
  border-radius: 50%;
  background-color: transparent;
  color: #486581;
}
button.active {
  background:#c6f7e2;
}
button:focus {
  outline:none;
}

.date-grid button:hover {
  /* .date-grid button:focus { */
  outline: none;
  background-color: #f0f4f8;
  color: #334e68;
}
.date-grid button:active {
  background-color:#c6f7e2;
}

/* todo: add media queries < 540px */

</style>