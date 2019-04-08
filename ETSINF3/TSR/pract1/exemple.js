var doble = function(x) {return x*2}
var dog = {nom: 'sultan',
			edad: 6,
			lladra: function() {console.log(this.nom)}
		}
		
console.log(doble(4))
var d = doble
console.log(d(4))

dog.lladra()
var f=dog.lladra
f()

var otraf = f.bind(dog)
otraf()
