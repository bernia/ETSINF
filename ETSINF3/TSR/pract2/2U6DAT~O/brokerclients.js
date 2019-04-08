const zmq = require('zmq')
let cli=[], req=[]
let sc = zmq.socket('router') // frontend
let sbw = zmq.socket('dealer')
args = process.argv.slice(2)
portC = args[0]
portBW = args[1]
sc.bind('tcp://*:'+ portC)
sbw.bind('tcp://*:' + portBW)
sc.on('message',(c,sep,m)=> {
	sbw.send([c,sep,m])
})
sbw.on('message',(estat,c,sep,m)=> {
	if(estat == 'torna') {
	cli.push(c);
	req.push(m);	
	} else {
		sc.send([c,'',m])
		if(cli.length>0) {
		sbw.send([cli.shift(),'',req.shift()])
		}
	}
	
})
setTimeout(()=>{process.exit(0)}, 20000)