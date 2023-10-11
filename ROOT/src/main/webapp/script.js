const track = document.getElementById("images");

const handleOnDown = e => track.dataset.mouseDownAt = e.clientX;

const handleOnUp = () => {
  track.dataset.mouseDownAt = "0";  
  track.dataset.prevPercentage = track.dataset.percentage;
}

const handleOnMove = e => {
  if(track.dataset.mouseDownAt === "0") return;
  
  const mouseDelta = parseFloat(track.dataset.mouseDownAt) - e.clientX,
        maxDelta = window.innerWidth / 2;
  
  const percentage = (mouseDelta / maxDelta) * -100,
        nextPercentageUnconstrained = parseFloat(track.dataset.prevPercentage) + percentage,
        nextPercentage = Math.max(Math.min(nextPercentageUnconstrained, 0), -100);
  
  track.dataset.percentage = nextPercentage;
  
  track.animate({
    transform: `translate(${nextPercentage}%, -50%)`
  }, { duration: 1200, fill: "forwards" });
  
  for(const image of track.getElementsByClassName("image")) {
    image.animate({
      objectPosition: `${100 + nextPercentage}% center`
    }, { duration: 1200, fill: "forwards" });
  }
}


/* -- Link copied when clicking the images -- */

const notification = document.getElementById('notification');

let isImageClicked = false;

for(const image of track.getElementsByClassName("image")) {
    image.addEventListener('click', function(e) {
        if (isImageClicked) return; // Prevents further clicks if an image has already been clicked
        isImageClicked = true; // Sets the flag to true when an image is clicked
        const link = this.dataset.link;
        if (link) {
            window.location.href = link; // Navigates to the link when an image is clicked
            isImageClicked = false;
        } else {
            showNotification(e, scrambleText('notification', "There's no link yet, be patient!", 25));
        }
    });
}

function showNotification(e, message) {
  // Calculate the position for the notification
  const y = window.innerHeight * 6 / 7;

  // Set the position and message of the notification
  notification.style.top = `${y}px`;
  notification.innerText = message;

  // Show the notification and hide it after 2 seconds
  notification.style.display = 'block';
  setTimeout(function() {
      notification.style.display = 'none';
      isImageClicked = false; // Resets the flag when the timeout completes
  }, 3000);
}


/* -- Had to add extra lines for touch events -- */

window.onmousedown = e => handleOnDown(e);

window.ontouchstart = e => handleOnDown(e.touches[0]);

window.onmouseup = e => handleOnUp(e);

window.ontouchend = e => handleOnUp(e.touches[0]);

window.onmousemove = e => handleOnMove(e);

window.ontouchmove = e => handleOnMove(e.touches[0]);


function scrambleText(elementId, finalText, delay) {
  var element = document.getElementById(elementId);
  var randomChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  var counter = 0;
  var scrambledText = "";

  var interval = setInterval(function() {
      if (counter < finalText.length) {
          scrambledText += randomChar[Math.floor(Math.random() * randomChar.length)];
          element.innerText = scrambledText;
          counter++;
      } else {
          clearInterval(interval);
          revealText(elementId, finalText, delay);
      }
  }, delay);
}

function revealText(elementId, finalText, delay) {
  var element = document.getElementById(elementId);
  var counter = 0;

  var interval = setInterval(function() {
      if (counter < finalText.length) {
          element.innerText = finalText.substring(0, counter + 1) + element.innerText.substring(counter + 1);
          counter++;
      } else {
          clearInterval(interval);
      }
  }, delay);
}

scrambleText("text", "Phạm Quang Duy - 21110760", 75);
scrambleText("text1", "Personal Projects Collection Website", 75);
scrambleText("text2", "Click On The Pictures To Redirect To The According Project", 75);







