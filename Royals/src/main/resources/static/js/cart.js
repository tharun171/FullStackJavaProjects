

const alldivs = document.getElementsByClassName("item");
let totalPay = 0;
let i = 0;
let buttonPressed = (e) =>{
	console.log("id touched is "+e.target.id);
}

for(let div of alldivs)
{
	div.addEventListener("click",buttonPressed);
	//console.log(div.getElementsByClassName('item1').item1.innerHTML);
	let id  = div.getElementsByClassName('item1').item1.innerHTML;
	let price = parseInt(div.getElementsByClassName(id).item3.innerHTML);
	//console.log(div.getElementsByClassName(id).item3.innerHTML);
	totalPay = totalPay  + price;
	//console.log(document.getElementsByClassName((document.getElementsByClassName('item1').item1.innerHTML).item3.innerHTML));
	console.log(totalPay);
	document.getElementById('totalPrice').innerHTML=totalPay;
				let total = 0;
				let deliveryfee = parseFloat(document.getElementById('deliveryfee').innerHTML);
				total = total + deliveryfee;
				console.log("total pay "+total);
				let deliverytip = parseFloat(document.getElementById('deliverytip').innerHTML);
				total = total + deliverytip;
				console.log("total pay "+total);
				let platformfee = parseFloat(document.getElementById('platformfee').innerHTML);
				total = total + platformfee;
				console.log("total pay "+total);
				let gst = parseFloat(document.getElementById('gst').innerHTML);
				total = total + gst;
				console.log("total pay "+total);
				
				total = total + totalPay;
				console.log(parseFloat(total));
				document.getElementById('total').innerHTML = total;
}

function minus(str,foodId)
{
	console.log("food id "+foodId);
	console.log("str name "+str);
	let quantity = parseInt(document.getElementById('quantity'+str).innerHTML);
	console.log("Quantity "+quantity);
	if(quantity>=1)
	{
		quantity = quantity -1;
		document.getElementById('quantity'+str).innerHTML = quantity;
		//document.getElementsByClassName('Baby Corn Manchurian(dry)').item3.innerHTML;
		let price = document.getElementsByClassName(str).item3.innerHTML;
		console.log("price "+price);
		let totalPrice = parseInt(document.getElementById('totalPrice'+str).innerHTML);
		totalPrice = price * 1;
		document.getElementById('totalPrice'+str).innerHTML = totalPrice*quantity;
		console.log(totalPrice);
		totalPay = totalPay - totalPrice;
		document.getElementById('totalPrice').innerHTML=totalPay;
		console.log(totalPay);
		console.log("minus button clicked");
		if(i==0)
		{
							console.log(totalPay);
				document.getElementById('totalPrice').innerHTML=totalPay;
				let total = 0;
				let deliveryfee = parseFloat(document.getElementById('deliveryfee').innerHTML);
				total = total + deliveryfee;
				console.log("total pay "+total);
				let deliverytip = parseFloat(document.getElementById('deliverytip').innerHTML);
				total = total + deliverytip;
				console.log("total pay "+total);
				let platformfee = parseFloat(document.getElementById('platformfee').innerHTML);
				total = total + platformfee;
				console.log("total pay "+total);
				let gst = parseFloat(document.getElementById('gst').innerHTML);
				total = total + gst;
				console.log("total pay "+total);
				
				total = total + totalPay;
				console.log(parseFloat(total));
				document.getElementById('total').innerHTML = total;
		}
	}
	if(quantity==0)
	{
		//quantity = quantity - 1;
		console.log(quantity);
		if(quantity==0)
		{
			console.log("remove this item");
			let id = foodId;
			console.log("id given "+id);
			const params = new URLSearchParams({id:id.toString()});
			console.log(window.location.host);
			console.log(window.location.pathname);
			let url = 'http://'+(window.location.host)+(window.location.pathname)+'/removeItem?'+params.toString();
			console.log("url "+url);
			fetch(url,
			{
				method:'GET',
				headers:{
					'Accept':'application/json',
					'content-Type':'application/json',
				},
			})
			.then(response =>{
				if(response.ok)
				{
					return response.text();
				}else{
					throw new Error('Network response was not found in cart js')
				}
			})
			.then(responseText => {
			  console.log("respinse text "+responseText);
			  window.location.href= "http://"+window.location.host+"/Royals/updatedCart";
			  window.location.href= "http://"+window.location.host+"/Royals/updatedCart";
			  // Open the new page after the redirect
			})
			.catch(error => {
			  console.log('Fetch error:', error);
			});
		}
		console.log(foodId);
	}
}

function plus(str,foodId)
{
	console.log("str name "+str);
	let quantity = parseInt(document.getElementById('quantity'+str).innerHTML);
	console.log("Quantity "+quantity);
	quantity = quantity + 1;
	console.log(quantity);
	document.getElementById('quantity'+str).innerHTML = quantity;
	//document.getElementsByClassName('Baby Corn Manchurian(dry)').item3.innerHTML;
	let price = document.getElementsByClassName(str).item3.innerHTML;
	console.log("price "+price);
	let totalPrice = parseInt(document.getElementById('totalPrice'+str).innerHTML);
	totalPrice = price * 1;
	document.getElementById('totalPrice'+str).innerHTML = totalPrice*quantity;
	totalPay = totalPay + totalPrice;
	document.getElementById('totalPrice').innerHTML=totalPay;
	console.log(totalPay);
	console.log("plus button clicked");
	if(i==0)
		{
							console.log(totalPay);
				document.getElementById('totalPrice').innerHTML=totalPay;
				let total = 0;
				let deliveryfee = parseFloat(document.getElementById('deliveryfee').innerHTML);
				total = total + deliveryfee;
				console.log("total pay "+total);
				let deliverytip = parseFloat(document.getElementById('deliverytip').innerHTML);
				total = total + deliverytip;
				console.log("total pay "+total);
				let platformfee = parseFloat(document.getElementById('platformfee').innerHTML);
				total = total + platformfee;
				console.log("total pay "+total);
				let gst = parseFloat(document.getElementById('gst').innerHTML);
				total = total + gst;
				console.log("total pay "+total);
				
				total = total + totalPay;
				console.log(parseFloat(total));
				document.getElementById('total').innerHTML = total;
		}
}

if (performance.navigation.type === 2) {
    // Page is loaded from cache, perform a forced reload
    location.reload(true);
}

function plusTip()
{
	console.log("clicked");
	console.log(document.getElementById("deliverytip").innerHTML);
	let tip = parseFloat(document.getElementById("deliverytip").innerHTML);
	tip = tip + 5;
	console.log(tip);
	document.getElementById("deliverytip").innerHTML = tip;
	document.getElementById("deliverytipvalue").innerHTML = tip;
	console.log(document.getElementById("total").innerHTML);
	let total = parseFloat(document.getElementById("total").innerHTML);
	total = total + 5
	document.getElementById("total").innerHTML = total;
}
function minusTip()
{
	console.log("clicked");
	console.log(document.getElementById("deliverytip").innerHTML);
	let tip = parseFloat(document.getElementById("deliverytip").innerHTML);
	console.log(tip);
	if(tip>0)
	{
	tip = tip - 5;
	document.getElementById("deliverytip").innerHTML = tip;
	document.getElementById("deliverytipvalue").innerHTML = tip;
	console.log(document.getElementById("total").innerHTML);
	let total = parseFloat(document.getElementById("total").innerHTML);
	total = total - 5;
	document.getElementById("total").innerHTML = total;
	}
	
}

function invoice()
{
	const params = new URLSearchParams();
	const map = new Map();	
	for(let div of alldivs)
	{
		let id  = (div.getElementsByClassName('item1').item1.innerHTML);
		console.log(id);
		let quantity  = (document.getElementById('quantity'+id).innerHTML);
		console.log(quantity);
		map.set(id,quantity);
	}
	console.log(map);
	sendMapAsQueryParameters(map);
	function encodeQueryData(data) 
	{
	  const queryItems = [];
	  for (const [key, value] of Object.entries(data)) {
	    queryItems.push(encodeURIComponent(key) + '=' + encodeURIComponent(value));
	  }
	  return queryItems.join('&');
	}
	function sendMapAsQueryParameters(map) 
	{
	  for (const [key, value] of map.entries()) {
	    params.append(key, value);
	}
	}
	
	console.log(map);
	console.log("invoice clicked");
	const deliverytip = parseFloat(document.getElementById("deliverytipvalue").innerHTML);
	const total  = parseFloat(document.getElementById("total").innerHTML);
	console.log(deliverytip);
	console.log(total);
	params.append("deliverytip",deliverytip);
	params.append("total",total);
	const queryString = params.toString();
	console.log(queryString);
	let newUrl = "http://"+window.location.host+"/Royals/invoice?"+queryString;
	console.log(newUrl);
	fetch(newUrl,
	{
		method:'GET',
		headers:
		{
			'Accept':'application/json',
			'Content-Type':'application/json',
		},
	})
	.then(response=>
	{
		if(response.ok){return response.text();}
		else{throw new Error('error in invoice sending data');}
	})
	.then(responseText=>
	{
		window.location.href= "http://"+window.location.host+"/Royals/invoice?"+queryString;
		console.log(responseText);
	})
	.catch(error=>
	{
		console.log(error);
	});
}





