function useAPI(URL, TYPE) {
  var request = new XMLHttpRequest();

  request.open("GET", URL);
  request.responseType = "json";
  request.send();
  request.onload = function () {
    var userInfos = request.response;
    showRequest(userInfos, TYPE);
  };
}

function showRequest(jsonObj, type) {
  switch (type) {
    case 1:
      var myTr = document.querySelector("#InfoAPI");
      var index = 0;
      var myTd1 = document.createElement("td");
      var myTd2 = document.createElement("td");
      var myTd3 = document.createElement("td");
      var myTd4 = document.createElement("td");
      var myTd5 = document.createElement("td");
      var myTd6 = document.createElement("td");

      myTd1.textContent = jsonObj[index].class;
      myTd2.textContent = jsonObj[index].grade;
      myTd3.textContent = jsonObj[index].season;
      myTd4.textContent = jsonObj[index].sumScore + "/136";
      myTd5.textContent = jsonObj[index].avgScore;

      // 디데이 계산
      var toDay = new Date();
      var endDate = new Date(jsonObj[index].endDay);
      myTd6.textContent = "D-" + Math.floor((endDate - toDay) / (1000 * 60 * 60 * 24));

      myTr.appendChild(myTd1);
      myTr.appendChild(myTd2);
      myTr.appendChild(myTd3);
      myTr.appendChild(myTd4);
      myTr.appendChild(myTd5);
      myTr.appendChild(myTd6);
      break;

    case 2:
      var myTbody = document.querySelector("#scheduleAPI");

      for (let index = 0; index < jsonObj.length; index++) {
        // 크롤링해서 3개만 가져오기
        if (index >= 3) {
          break;
        }

        var myTr = document.createElement("tr");
        var myTd1 = document.createElement("td");
        var myTd2 = document.createElement("td");
        var myTd3 = document.createElement("td");
        var myA = document.createElement("a");

        myA.setAttribute("href", jsonObj[index].url);
        myA.setAttribute("class", "card-set");

        myA.textContent = jsonObj[index].title;
        myTd1.appendChild(myA);

        myTd2.textContent = jsonObj[index].date;
        myTd3.textContent = jsonObj[index].views;

        myTr.appendChild(myTd1);
        myTr.appendChild(myTd2);
        myTr.appendChild(myTd3);

        myTbody.appendChild(myTr);
      }
      break;

    default:
      break;
  }
}
