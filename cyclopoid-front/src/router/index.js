import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import FormList from '@/components/FormList'
import FormAdd from '@/components/FormAdd'
import FormEdit from '@/components/FormEdit'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/form/list',
      name: 'Forms',
      component: FormList
    },
    {
      path: '/form/by/id/:formId',
      name: 'FormById',
      component: FormEdit
    },
    {
      path: '/form/add',
      name: 'FormAdd',
      component: FormAdd
    }
  ]
})
