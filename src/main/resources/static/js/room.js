const roomService = (function () {
    function buildRoomTr(room) {
        return `
                    <tr>
                        <td>${room.id}</td>
                        <td><a href="/room.html?roomId=${room.id}">${room.name}</a></td>
                        <td>${room.countryCode}</td>
                        <td>${room.lightIsOn}</td>
                    </tr>
               `;
    }

    const getRooms = function() {
        $.get("api/room", {}, function (data) {
            $("#roomsTable tbody").empty();
            for (const room of data) {
                $("#roomsTable tbody:last-child").append(buildRoomTr(room));
            }
        });
    }

    const getRoom = function(roomId, callback) {
        $.get(`api/room/${roomId}`, {}, function (data) {
            $("#roomIdCell").html(data.id);
            $("#roomNameCell").html(data.name);
            $("#countryCodeCell").html(data.countryCode);
            $("#lightIsOnCell").html(`${data.lightIsOn}`);
            if (callback) {
                callback();
            }
        });
    }

    const createRoom = function(callback) {
        const countryCode = $("#countrySelect").val();
        const roomName = $("#roomName").val();

        $.ajax({
                url: "/api/room",
                type: "POST",
                data: JSON.stringify({
                    name: roomName,
                    countryCode: countryCode
                }),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: () => {
                    callback();
                }
            }
        );
    }

    const switchRoomLight = function() {
        const roomId = $("#roomIdCell").text();
        const currentLightStatus = $("#lightIsOnCell").text();
        const lightIsOn = currentLightStatus === "true" ? "false" : "true";
        $.ajax({
                url: `/api/room/${roomId}/status/${lightIsOn}`,
                type: "POST",
                success: () => {
                    getRoom(roomId, undefined);
                }
        });
    }

    return {
        getRooms: getRooms,
        getRoom: getRoom,
        createRoom: createRoom,
        switchRoomLight: switchRoomLight
    }
})();
