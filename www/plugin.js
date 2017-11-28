
var exec = require('cordova/exec');

var PLUGIN_NAME = 'BasedemoPlugin';

cordova.plugins.BasedemoPlugin = {
  echo: function (phrase, success_cb, error_cb) {
    exec(success_cb, error_cb, PLUGIN_NAME, 'echo', [phrase]);
  },
  echoArray: function (array, success_cb, error_cb) {
    exec(success_cb, error_cb, PLUGIN_NAME, 'echoArray', array);
  },
  getDate: function (success_cb, error_cb) {
    exec(success_cb, error_cb, PLUGIN_NAME, 'getDate', []);
  },
  getList: function (success_cb, error_cb) {
    exec(success_cb, error_cb, PLUGIN_NAME, 'getList', []);
  },
  getError: function (success_cb, error_cb) {
    exec(success_cb, error_cb, PLUGIN_NAME, 'getError', []);
  }
};

module.exports = cordova.plugins.BasedemoPlugin;
