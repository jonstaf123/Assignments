var myToken ="xoxp-63743851541-69465217716-82793550423-dc7875d7b5f1eb70d2704bb779d90f42"
$(document).ready(function(){		
	 $("#post-box").click(function() {
	console.log("Clicked button");
	 
	var textMsg = $('#msg-box').val();
 $.ajax("https://slack.com/api/chat.postMessage", {
		
   data: {
	token:myToken,
	channel:channelName,
	text:textMsg,
	username:"user007" 
}
	 }).then(function(result) {
	 	method: "POST"
		console.log(result);
		var clear="";
		$('#msg-box').val(clear);
	})	
})

  $.ajax("https://slack.com/api/channels.list", {
    data: {
      token:myToken,
    }
  }).then(function(result) {
  	
    console.log("response is done");
for (var i=0; i < result.channels.length; i++) {
      
      var item = $('<ul style="list-style: none;"><li></li></ul>');

      var radioButton = $('<input type="radio" class ="rad" name="channelButton"'
       +' id="'+result.channels[i].id+'">' + result.channels[i].name + '<br/>');


      item.append( radioButton );
      
      
      $("#channelDiv").append( item );
    }
 })  
}) 

// function findChannel() {
// 	cntChannels = Number( $("#rad").val() );
// 	for(var idx = 0; idx < cntChannels; idx++) {
// 		var theName = $("#rad").val(name)
// 		var isChecked = document.getElementById(name).checked;
// 		if(isChecked) {
// 			var channelName = $("#channelButton").val();
// 			console.log( channelName );
// 			return channelName;
// 		}
// 	}
// }
// })

    

