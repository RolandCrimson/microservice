function initRps() {
    let choice = document.querySelector('#rps');
    let user = document.querySelector('#user');
    choice.selectedIndex = "0";
    user.value = "";
    let user_image = document.querySelector('#userImage');
    user_image.src = "/image/rps.png";
    let computer_choice = document.querySelector('#opponentImage');
    computer_choice.src = "/image/rps.png";
}

function getImageSource(index) {
    let img_src = "";
    switch(index) {
        case '0':
            img_src = '/image/rps.png';
            break;
        case '가위':
            img_src = '/image/scissors.png';
            break;
        case '바위':
            img_src = '/image/rock.png';
            break;
        case '보':
            img_src = '/image/paper.png';
            break;
        default:
            img_src = '/image/rps.png';
    }
    return img_src;
}

function drawImage() {
    let choice = document.querySelector('#rps');
    let user_image = document.querySelector('#userImage');
    user_image.src = getImageSource(choice.options[choice.selectedIndex].value);
}

async function sendData() {
    let choice = document.querySelector('#rps');
    let user = document.querySelector('#user');
	
	let formData = new FormData();

	formData.append("userChoice", choice.options[choice.selectedIndex].value);
	formData.append("userAlias", user.value);
	
	const options = {
        method: "post",
        body: formData,
    }
    target = "http://localhost:8080/results";
    try {
        let response = await fetch(target, options);
        let result = await response.json();
        if (result.outcome == "승") {
            document.querySelector('.result-message').innerHTML = "이겼습니다!";
        } else if (result.outcome == "패") {
            document.querySelector('.result-message').innerHTML = "졌습니다! 그래도 포기하지 마세요!";
        } else {
            document.querySelector('.result-message').innerHTML = "비겼습니다! 다시 한 번 도전해 보세요!";
        }
        let computer_choice = document.querySelector('#opponentImage');
        computer_choice.src = getImageSource(result.opponent);
        updateStats(user.value);
    }catch(err) {
        alert(err);
    }
}

async function updateStats(alias){
	target = "http://localhost:8080/results" + "?alias=" + alias;
	let table_body = document.querySelector('#results-body');
	table_body.innerHTML = ""
	
	const options = {
        method: "get"
    }
  
    try {
        let response = await fetch(target, options);
        let result = await response.json();
        for(let element of result) {
            let tr_tag = document.createElement("tr");
            let td_tag01 = document.createElement("td");
            td_tag01.innerHTML = element.id;
            let td_tag02 = document.createElement("td");
            td_tag02.innerHTML = element.user;
            let td_tag03 = document.createElement("td");
            td_tag03.innerHTML = element.opponent;
            let td_tag04 = document.createElement("td");
            td_tag04.innerHTML = element.outcome;
            tr_tag.appendChild(td_tag01);
            tr_tag.appendChild(td_tag02);
            tr_tag.appendChild(td_tag03);
            tr_tag.appendChild(td_tag04);
            table_body.appendChild(tr_tag);
        }
        
    } catch(err) {
        alert(err);
    }
	
}
