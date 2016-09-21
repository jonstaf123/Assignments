$(document).ready(function() {
  
  var counter = 0;
  $("#increment").click(function() {

    console.log("Clicked button");
      //change color

      counter++;

      if (counter > 7) {
      $("#count-box").addClass("red");
    } else {
      // Record and display count
      $("#count-box").removeClass("red");
    }

      if(counter %2 == 0) {
        $("#count-box").addClass("even");
      } else {
            $("#count-box").removeClass("even");
      }
      $( "#count-box" ).val(counter)
      console.log(counter)
      
    

    })    
    

  $("#decrement").click(function() {
    console.log("Clicked button");

        counter--;
      
      $( "#count-box" ).val(counter)
      console.log(counter)
    // change color
    if (counter > 7) {
      $("#count-box").addClass("red");
    } else {
      // Record and display count
      $("#count-box").removeClass("red");
    }
      if(counter %2 == 0) {
        $("#count-box").addClass("even");
      } else {
            $("#count-box").removeClass("even");
      }
})
$("#reset").click(function() {
   $("#count-box").addClass("even");
  $("#count-box").removeClass("red");
    console.log("Clicked button");
        counter = 0;
        $( "#count-box" ).val(counter)

})
})
