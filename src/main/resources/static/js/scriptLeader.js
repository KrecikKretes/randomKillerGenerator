function changeToDraw(id){
    location.href='http://localhost:8080/' + id + '/draw';
}

function showInfo(matches){
    document.getElementById("popupEnd").style.animation = "visibility-animation 2s";
    document.getElementById("popupEnd").style.visibility  = "visible";
    document.getElementById("popupEnd").style.opacity  = 1;

    document.getElementById("popupTeam1Name").innerText = matches.team1;
    document.getElementById("popupTeam2Name").innerText = matches.team2;
    document.getElementById("popupResultName").innerText = matches.result;

    if(matches.result == "Nie rozegrano"){
        document.getElementById("popupKillerTr").style.display = "none";
        document.getElementById("popupMapTr").style.display = "none";
        document.getElementById("popupAddonTr").style.display = "none";
    }else{
        document.getElementById("popupKillerName").innerText = matches.killer;
        document.getElementById("popupMapName").innerText = matches.map;
        document.getElementById("popupAddon").innerText = matches.addon;
    }





}