/**
 * 
 */

const list = new Set();
let cartSize;
let arr = Array.from(list);

function newOne()
{
	console.log("new one called");
	arr = [];
	console.log(arr);
}

function performLogout() {
    // Perform logout actions here
    console.log("clicked");
    window.sessionStorage.clear;
    window.history.pushState(null, null, '/');
    window.addEventListener('popstate', function() {
    window.history.pushState(null, null, '/');
    });
}



function handleButtonClick(foodid) {
	let existItems = parseInt(document.getElementById("cartItems").innerHTML);
	console.log(existItems);
	console.log(foodid);
	console.log(list.has(foodid));
	console.log(document.getElementById(foodid).innerHTML);
	if (list.has(foodid) == true) {
		const button = document.getElementById(foodid);
		button.innerHTML = 'ADD';
		list.delete(foodid);
		existItems=existItems-1;
		console.log("after deletion " + list.has(foodid));
		console.log("after deletion " + list);
	}
	else {
		const button = document.getElementById(foodid);
		button.innerHTML = 'ADDED';
		list.add(foodid);
		existItems=existItems+1;
	}
	console.log(list);
	alert("Button clicked!");
	console.log(document.getElementById(foodid));
	cartSize = list.size;
	console.log("cartSize len " + cartSize);
	console.log(list.size);

	
	console.log(document.getElementById("cartItems").innerHTML = existItems);
	
	//converting set to array
	arr = Array.from(list);
	console.log("array "+arr);
	
	
}



function func()
{
	const arrayAsString = arr.join(',');
	console.log(arrayAsString);
	
	const params = new URLSearchParams({ textData: arrayAsString });
	console.log("params "+params)
	// Construct the URL with the parameters
	//this is a new url in AppController and it forwards to cart
	const url = 'http://localhost:9090/Royals/data?' + params.toString();
	console.log(url);
	// Send a GET request with URL parameter to retrieve the view
	fetch(url, {
	  method: 'GET',
	  headers: {
	    'Accept': 'application/json',
	    'Content-Type': 'application/json',
	  },
	})
	.then(response => {
	  if (response.ok) {
	    return response.text();
	  } else {
	    throw new Error('Network response was not ok.');
	  }
	})
	.then(responseText => {
	  console.log(responseText);
	  window.location.href="http://"+window.location.host+"/Royals/cart";
	  window.location.href="http://"+window.location.host+"/Royals/cart";
	})
	.catch(error => {
	  console.log('Fetch error:', error);
	});

}

if (performance.navigation.type === 2) {
    // Page is loaded from cache, perform a forced reload
    location.reload(true);
}

console.log("js invoked");
