import * as $ from 'jquery'

$(document).ready(() => {
  console.log('hello world!')
  const button = $('button')
  const counter = $('counter')
  console.log(button)
  console.log(counter)
  button.click(() => $.get('/hello'))
})
