$(document).ready(function(){
  	 $.ajax({
        type:"GET",
      url: "http://localhost:8080/api/booking",
      statusCode: {
          200: function(data) {
          $("#quantity").text(data.length);
            data.forEach(element => {
                $("#notify").append(`<a class="dropdown-item d-flex align-items-center" href="http://localhost:8080/booking">
                <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://static2.yan.vn/YanNews/2167221/202003/dan-mang-du-trend-thiet-ke-avatar-du-kieu-day-mau-sac-tu-anh-mac-dinh-b0de2bad.jpg" alt="">
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