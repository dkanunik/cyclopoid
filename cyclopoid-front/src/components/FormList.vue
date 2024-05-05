<template>
    <div class="content">
      <ul id="form-list">
        <li class="form-item" v-for="form in forms">
          <router-link :to="{name: 'FormById', params: { formId: form.id }}">
            {{ form.name }}
          </router-link>
        </li>
      </ul>
    </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'FormList',

  data () {
    return {
      forms: []
    }
  },

  created () {
    this.fetchData()
  },

  watch: {
    '$route': 'fetchData'
  },

  methods: {
    fetchData () {
      axios.get('http://127.0.0.1:8080/form/all')
        .then((resp) => {
          this.forms = resp.data.forms
        })
        .catch((err) => {
          console.log(err)
        })
    }
  }
}
</script>

<style scoped>

  * {
    border: 0 solid black;
  }

  div.content {
    display: inline-block;
    width: 33%;
  }

  li.form-item {
    width: 100px;
    text-align: left;
  }

</style>
