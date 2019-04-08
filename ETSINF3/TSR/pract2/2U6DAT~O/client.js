const zmq = require('zmq')
let req = zmq.socket('req');
args = process.argv.slice(2);
urlFE = args[0]
req.identity = args[1]
txtPeticion = args[2]
req.connect(urlFE)
req.on('message', (msg)=> {
	console.log('resp: '+msg)
	process.exit(0);
})
req.send(txtPeticion)
setTimeout(()=>{process.exit(0)}, 20000)
