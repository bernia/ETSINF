const zmq = require('zmq')
let workers=[]
let sbc = zmq.socket('dealer')
let sw = zmq.socket('router') // backend
args = process.argv.slice(2)
portBC = args[0]
portW = args[1]
sbc.connect('tcp://localhost:'+ portBC)
sw.bind('tcp://*:' + portW)
sbc.on('message',(c,sep,m)=> {
	if (workers.length==0) { 
		sbc.send(['torna',c,sep,m])
	} else {
		sw.send([workers.shift(),'',c,'',m])
	}
})
sw.on('message',(w,sep,c,sep2,r)=> {
	if (c=='') {workers.push(w);return}
	workers.push(w)
	sbc.send(['resp',c,'',r + ' '])
})

setTimeout(()=>{process.exit(0)}, 20000)