let killersIdArray = [];
let killersNameArray = [];
let killersFileArray = [];
let mapIdArray = [];
let mapNameArray = [];
let mapFileArray = [];
let last_idKiller = 15;
let last_idMap = 3;
let numbersKiller = 0;
let numbersMap = 0;

function start(killers, maps){
   for(let i = 0; i < 5; i++){
      killersIdArray.push(killers[i].id);
      killersNameArray.push(killers[i].name);
      killersFileArray.push(killers[i].file);
   }
   for(let i = 0; i < 2; i++){
      mapIdArray.push(maps[i].id);
      mapNameArray.push(maps[i].name);
      mapFileArray.push(maps[i].file);
   }
}


function showAlert() {
   alert("The button was clicked!");
}


function changeOpacityImg(id, div){
   let elements = document.getElementsByClassName(div + id);
   let e1 = elements[0];
   let e2 = elements[1];

   let interval;
   let opacity;
   if (e1.style.opacity == 1.0 || e1.style.opacity == "") {
      opacity = 1;

      if(div == 'killer'){
         numbersKiller++;
         last_idKiller = last_idKiller - killersIdArray.indexOf(id) - 1;
      }else{
         numbersMap++;
         last_idMap = last_idMap - mapIdArray.indexOf(id) - 1;
      }

      interval = setInterval(() => {
         if (opacity > 0.1) {
            change_opacity(e1, e2, opacity)
            opacity -= 0.05;
         } else {
            clearInterval(interval)
         }
      }, 50)
   } else {
      if (e1.style.opacity == 0.2) {

         if(div == 'killer'){
            numbersKiller--;
            last_idKiller = last_idKiller + killersIdArray.indexOf(id) - 1;
         }else{
            numbersMap--;
            last_idMap = last_idMap + mapIdArray.indexOf(id) - 1;
         }

         opacity = 0.2;
         interval = setInterval(() => {
            if (opacity < 1) {
               change_opacity(e1, e2, opacity)
               opacity += 0.05;
            } else {
               clearInterval(interval)
            }
         }, 50)
      }
   }

   if(numbersKiller == 4 || numbersMap == 1){
      onMapChoose(div)
   }
}


function change_opacity(e1, e2, opacity){
   e1.style.opacity = opacity;
   e2.style.opacity = opacity;
}

function onMapChoose(div){
   if(div == 'killer'){
      last_idKiller--;
      let a = document.getElementsByClassName('killer' + killersIdArray[last_idKiller]);
      document.getElementById("idKillerForm").value = killersIdArray[last_idKiller];
      document.getElementById("div_maps").style.animation = "visibility-animation 2s";
      document.getElementById("div_maps").style.visibility = "visible"
      a[1].style.animation= "pulse-animation 1s infinite";

      document.getElementById("popupKillerName").innerText = killersNameArray[last_idKiller];
      document.getElementById("popupKillerImg").src = killersFileArray[last_idKiller];

   }else{
      last_idMap--;
      let a = document.getElementsByClassName('map' + mapIdArray[last_idMap]);
      a[1].style.animation= "pulse-animation 1s infinite";

      document.getElementById("idMapForm").value = mapIdArray[last_idMap];
      document.getElementById("popupMapName").innerText = mapNameArray[last_idMap];
      document.getElementById("popupMapImg").src = mapFileArray[last_idMap];

      document.getElementById("div_addons").style.animation = "visibility-animation 2s";
      document.getElementById("div_addons").style.visibility = "visible"
   }
}

function onAddonChoose(addonImg){
   let addonElements = document.getElementsByClassName("addonsImg");
   for(let i = 0; i < addonElements.length; i++){
      addonElements[i].style.opacity=0.2;
   }
   addonImg.style.opacity = 1;
   addonImg.style.animation= "pulse-animation 1s infinite";

   document.getElementById("popupAddonImg").src = addonImg.src;
   document.getElementById("addonForm").value = addonImg.src;

   document.getElementById("popupEnd").style.animation = "visibility-animation 2s";
   document.getElementById("popupEnd").style.visibility  = "visible";
   document.getElementById("popupEnd").style.opacity  = 1;

   document.getElementById("div_killers").style.animation = "opacityOff-animation 1s";
   document.getElementById("div_maps").style.animation = "opacityOff-animation 1s";
   document.getElementById("div_addons").style.animation = "opacityOff-animation 1s";

   document.getElementById("div_killers").style.opacity = 0;
   document.getElementById("div_maps").style.opacity = 0;
   document.getElementById("div_addons").style.opacity = 0;
}

function save(id){
   document.forms["drawForm"].submit();

}