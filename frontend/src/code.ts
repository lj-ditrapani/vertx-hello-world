import * as $ from 'jquery'

$(document).ready(() => {
  console.log('hello world!')
  const button = $('#button')
  const counter = $('#counter')
  button.click(() => $.get('/hello'))
  const location = document.location
  const ws = new WebSocket(`ws://${location.hostname}:${location.port}`)
  ws.addEventListener('open', _ => {
    console.log('Connected')
  })
  ws.addEventListener('message', ev => {
    console.log(`RECV: ${ev.data}`)
    counter.html(ev.data)
  })
})
