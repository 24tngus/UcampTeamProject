<template>
  <div class="container" id="main-container">
    <h2>Réservation</h2>
    <form>
      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputEmail4">Nom</label>
          <input type="email" class="form-control" id="inputEmail4" placeholder="Dupond">
        </div>
        <div class="form-group col-md-6">
          <label for="inputPassword4">Prénom</label>
          <input type="password" class="form-control" id="inputPassword4" placeholder="Jean">
        </div>
      </div>
      <div class="form-group">
        <label for="inputAddress">Numéro de téléphone</label>
        <input type="tel" class="form-control" id="inputAddress" placeholder="0601020304">
      </div>
      <div class="form-group">
        <table class="table reservation">
          <thead>
          <tr>
            <th scope="col">Mardi</th>
            <th scope="col">Mercredi</th>
            <th scope="col">Jeudi</th>
            <th scope="col">Vendredi</th>
            <th scope="col">Samedi</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>
              <div class="hour">8:00</div>
            </td>
            <td>
              <div class="hour">8:00</div>
            </td>
            <td>
              <div class="hour complet">-</div>
            </td>
            <td>
              <div class="hour">8:00</div>
            </td>
            <td>
              <div class="hour">8:00</div>
            </td>
          </tr>
          <tr>
            <td>
              <div class="hour">8:30</div>
            </td>
            <td>
              <div class="hour complet">-</div>
            </td>
            <td>
              <div class="hour complet">-</div>
            </td>
            <td>
              <div class="hour">8:30</div>
            </td>
            <td>
              <div class="hour">8:30</div>
            </td>
          </tr>
          <tr>
            <td>
              <div class="hour complet">-</div>
            </td>
            <td>
              <div class="hour">9:00</div>
            </td>
            <td>
              <div class="hour">9:00</div>
            </td>
            <td>
              <div class="hour complet">-</div>

            </td>
            <td>
              <div class="hour">9:00</div>
            </td>
          </tr>
          <tr>
            <td>
              <div class="hour">9:30</div>
            </td>
            <td>
              <div class="hour">9:30</div>
            </td>
            <td>
              <div class="hour">9:30</div>
            </td>
            <td>
              <div class="hour complet">-</div>

            </td>
            <td>
              <div class="hour">9:30</div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
      <div class="form-group text-right">
        <button type="submit" class="btn btn-primary">예약</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {

};
</script>

<style scoped>
body {
  background: rgb(238, 242, 246);;
}

.container{
  max-width: 460px;
}

#main-container {
  margin-top: 1rem;
  margin-bottom: 1rem;
  padding:1rem 1rem;
  background: #fff;
  border: 1px solid lightgray;
}

.table.reservation {
  table-layout: fixed;
  thead {
    th {
      text-align:center;
      color: rgb(67, 95, 113);
      font-size: 0.9em;
    }
  }
  tbody {
    td {
      .hour {
        background: rgb(204, 236, 250);
        border-radius: 4px;
        text-align: center;
        padding: 4px;
        color: rgb(67, 95, 113);
      }
      .complet {
        background: transparent;
        margin-left: -2px;
      }
    }
  }
}
</style>