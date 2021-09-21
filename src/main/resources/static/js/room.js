const roomService = (function () {
    function buildRoomTr(room) {
        return `
                    <tr>
                        <td>${room.id}</td>
                        <td>${room.name}</td>
                        <td>${room.countryCode}</td>
                        <td>${room.lightIsOn}</td>
                    </tr>
               `;
    }

    const getRooms = function () {
        $.get("api/room", {}, function (data) {
            console.log(data);
            $("#roomsTable tbody").empty();
            for (room of data) {
                $("#roomsTable tbody:last-child").append(buildRoomTr(room));
            }
        });
    }
    return {
        getRooms: getRooms
    }
})();