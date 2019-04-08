const zmq = require('zmq')
let req = zmq.socket('req')

args = process.argv.slice(2)
urlBE = args[0]
req.identity = args[1]
txtRespuesta = args[2]
req.connect(urlBE)
req.on('message', (c,sep,msg)=> {
	setTimeout(()=> {
		req.send([c,'',txtRespuesta])
	}, 1000)
})
req.send(['','','',''])
setTimeout(()=>{process.exit(0)}, 20000)
