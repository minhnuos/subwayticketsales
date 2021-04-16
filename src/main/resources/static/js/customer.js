$(document).ready(function(){
  	 $.ajax({
        type:"GET",
      url: "http://localhost:8080/api/booking",
      statusCode: {
          200: function(data) {
          $("#quantity").text(data.length);
            data.forEach(element => {
                $("#notify").append(`<a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://scr.vn/wp-content/uploads/2020/07/H%C3%ACnh-avatar-m%C3%A8o-d%E1%BB%85-th%C6%B0%C6%A1ng.jpg" alt="">
                    <div class="status-indicator bg-success"></div>
                </div>
                <div class="font-weight-bold">
                    <div class="text-truncate"> ${element.name} đã đặt vé</div>
                    <div class="small text-gray-500">Thời gian · ${element.time}</div>
                </div>
            </a>
            `);
    

          });
          $("#notify").append(`<a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>`);
          }
      }
  })
});