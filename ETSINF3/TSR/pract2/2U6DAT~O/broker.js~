const zmq = require('zmq')
let cli=[], req=[], workers=[]
let sc = zmq.socket('router') // frontend
let sw = zmq.socket('router') // backend
args = process.argv.slice(2)
portFE = args[0]
portBE = args[1]
sc.bind('tcp://*:'+ portFE)
sw.bind('tcp://*:' + portBE)
let compt = 0
let comptadors = {}
sc.on('message',(c,sep,m)=> {
	if (workers.length==0) { 
		cli.push(c); req.push(m); return
	} else {
		sw.send([workers.shift(),'',c,'',m])
	}
})
sw.on('message',(w,sep,c,sep2,r)=> {
    if (c=='') {workers.push(w); comptadors[w]=0; return}
	if (cli.length>0) { 
		sw.send([w,'',
			cli.shift(),'',req.shift()])
	} else workers.push(w)
	compt++
	comptadors[w]++
	sc.send([c,'',r + ' ' + compt])
})

setInterval(()=>{console.log('Comptador general: ' + compt)
						console.log('Comptadors: ', comptadors)}, 5000)
setTimeout(()=>{process.exit(0)}, 10000)