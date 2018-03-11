#import "ZenDriveClass.h"
#import <ZendriveSDK/Zendrive.h>

@implementation ZenDriveClass

- (void)login:(CDVInvokedUrlCommand*)command
{
    ZendriveConfiguration *configuration = [[ZendriveConfiguration alloc] init];
    configuration.applicationKey = [[command arguments] objectAtIndex:1];
    configuration.driverId = [[command arguments] objectAtIndex:0];

    NSLog(@"ZenDrive OPEN!!");

   [Zendrive
    setupWithConfiguration:configuration delegate:self
    completionHandler:^(BOOL success, NSError *error) {
        CDVPluginResult* result = nil;
        if(success) {
            NSLog(@"ZenDrive SETTED!!");
            result = [CDVPluginResult
                   resultWithStatus:CDVCommandStatus_OK
                   messageAsString:@"OK"];

            [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
        } else {
            NSLog(@"ZenDrive Failed!!");
            result = [CDVPluginResult
                   resultWithStatus:CDVCommandStatus_ERROR
                   messageAsString:@"ERROR"];

            [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
        }
    }];


}

@end
