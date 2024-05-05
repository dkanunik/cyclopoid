<template>
    <div class="content">
      <form @submit.prevent="submit">
        <input type="text" v-model="formdata.name"/>
        <button type="submit">
          Add
        </button>
      </form>
      <ul v-if="errors && errors.length">
        <li v-for="error of errors">
          {{error.message}}
        </li>
      </ul>
    </div>
</template>

<script>

import axios from 'axios'

export default {
  data () {
    return {
      formdata: {name: ''},
      errors: []
    }
  },
  methods: {
    submit () {
      axios.post('http://127.0.0.1:8080/form/add', {
        formName: this.formdata.name
      })
        .then(res => {
          console.log(res)
        })
        .catch(err => {
          console.log(err)
        })
    },
    mounted () {

    },
    components: {}
  }
}
</script>
