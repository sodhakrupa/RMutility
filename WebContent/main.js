function displayContent(contentDiv){
	
	var x = document.getElementsByClassName('maincontent');
	for(var i=0;i<x.length;i++){
		x[i].style.display = 'none';
	}
	contentDiv.style.display = 'block';
}

function validateFileExtension(fileName){
	
	var regex = new RegExp("(.*?)\.xml$");
	if(!regex.test(fileName)){
		document.getElementById("fileTypeError").innerHTML = "Please upload XML file";
		document.getElementById("requestFile").value = "";
	}
	else{
		document.getElementById("fileTypeError").innerHTML = "";
	}
}

