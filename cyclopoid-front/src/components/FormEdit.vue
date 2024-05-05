<template>
  <div class="content">
    <b>name</b>: {{form.name}}
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'FormEdit',

  data () {
    return {
      form: {}
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
      axios.get('http://127.0.0.1:8080/form/by/id/1')
        .then((resp) => {
          this.form = resp.data.form
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

</style>
