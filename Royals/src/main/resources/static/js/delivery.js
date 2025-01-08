
function func1(id)
{
	console.log("clicked");
	console.log(id);
	console.log(document.getElementsByClassName('0').abc.innerHTML);
}


function func(id)
{
	console.log("clicked");
	console.log(id);
	
	var id = id;
	console.log("id "+id);
	const params = new URLSearchParams({ index:id });
	
	// Construct the URL with the parameters
	//this is a new url in AppController and it forwards to cart
	const url = 'http://localhost:9090/Royals/removeAdd?' + params.toString();
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
		window.location.href='http://'+(window.location.host)+'/Royals/delivery';
	  console.log(responseText);
	})
	.catch(error => {
	  console.log('Fetch error:', error);
	});
}


function set(id,button)
{
	console.log("set fucntion clicked");
	console.log(id);
	
	var id = document.getElementsByClassName(id).abc.innerHTML;
	id = id.toString();
	console.log("id "+id);
	const params = new URLSearchParams({ address:id });
	
	console.log("button innertext "+button.innerText);
	if (button.innerText === "Set Primary") {
	       button.innerText = "Remove Primary";  // Change the text to "Address Set"
	   } else {
	       button.innerText = "Set Primary";  // Change the text back to "Set Address"
	   }
	
	// Construct the URL with the parameters
	//this is a new url in AppController and it forwards to cart
	const url = 'http://localhost:9090/Royals/setPrimary?' + params.toString();
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
		window.location.href='http://'+(window.location.host)+'/Royals/';
	  console.log(responseText);
	})
	.catch(error => {
	  console.log('Fetch error:', error);
	});
}