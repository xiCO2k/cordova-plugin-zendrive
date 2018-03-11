var cordova = require('cordova');

module.exports = {
    login: function (driverId, sdkId, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Zendrive", "login", [driverId, sdkId]);
    }
}
