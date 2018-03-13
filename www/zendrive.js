var cordova = require('cordova');

module.exports = {
    login: function (driverId, sdkId, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Zendrive", "login", [driverId, sdkId]);
    },
    setDriverDetectionOn: function(successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Zendrive", "setDriverDetectionOn", []);
    },
    setDriverDetectionOff: function(successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Zendrive", "setDriverDetectionOff", []);
    }
}
