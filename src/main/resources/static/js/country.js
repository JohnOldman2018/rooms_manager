const countryService = (function () {
    function buildCountryOption(country) {
        return `<option value="${country.code}">${country.name}</option>`;
    }
    const getCountries = function () {
        $.get("api/country", {}, function (data) {
            $("#countrySelect").empty();
            for (const country of data) {
                console.log(country);
                $("#countrySelect").append(buildCountryOption(country));
            }
        });
    }
    return {
        getCountries: getCountries
    }
})();
