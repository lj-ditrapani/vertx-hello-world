var ws = new WebSocket("ws://localhost:44770"); ws.addEventListener('open', ev => { console.log('Connected') }); ws.addEventListener('message', ev => { console.log(`RECV: ${ev.data}`) });
