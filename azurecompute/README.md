
=== Setting up test credentials

Azure requests are signed by via SSL certificate. You need to upload one into your account in order to run tests.

```bash
# create the certificate request
mkdir -m 700 $HOME/.jclouds
openssl req -x509 -nodes -days 365 -newkey rsa:1024 -keyout $HOME/.jclouds/azure.pem -out $HOME/.jclouds/azure.pem
# create the p12 file, and note your export password. This will be your test credentials.
openssl pkcs12 -export -out $HOME/.jclouds/azure.p12 -in $HOME/.jclouds/azure.pem -name "jclouds :: $USER"
# create a cer file which you upload to the management console to authorize this certificate.
# https://manage.windowsazure.com/@ignasibarreragmail.onmicrosoft.com#Workspaces/AdminTasks/ListManagementCertificates
# note you need to press command+shift+. to display hidden directories in a open dialog in osx
openssl x509 -inform pem -in $HOME/.jclouds/azure.pem -outform der -out $HOME/.jclouds/azure.cer
```

Once you do this, you will set the following to run the live tests.
```bash
mvn -Plive -Dtest.jclouds.azurecompute.subscription-id=12345678-abcd-dcba-abdc-ba0987654321
-Dtest.azurecompute.credential=P12_EXPORT_PASSWORD
-Dtest.azurecompute.identity=$HOME/.jclouds/azure.p12
```
