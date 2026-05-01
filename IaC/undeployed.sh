echo Deleting stack [Redis]...
aws cloudformation delete-stack  --stack-name app-redis-stack
echo done!

echo Deleting stack [Security_Groups]...
aws cloudformation delete-stack  --stack-name app-security-stack
echo done!

echo Deleting stack [Subnets]...
aws cloudformation delete-stack  --stack-name app-subnets-stack
echo done!

echo Deleting stack [VPC]...
aws cloudformation delete-stack  --stack-name pp-vpc-stack
echo done!