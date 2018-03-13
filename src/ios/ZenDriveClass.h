#import <Cordova/CDV.h>

@interface ZenDriveClass : CDVPlugin

- (void) login:(CDVInvokedUrlCommand*)command;

- (void) setDriverDetectionOn:(CDVInvokedUrlCommand*)command;

- (void) setDriverDetectionOff:(CDVInvokedUrlCommand*)command;

@end
