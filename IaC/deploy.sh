echo Deploying stack [VPC]...
aws cloudformation deploy \
  --template-file vpc.yaml \
  --stack-name app-vpc-stack
echo done!

echo Deploying stack [Subnets]...
aws cloudformation deploy \
  --template-file subs.yaml \
  --stack-name app-subnets-stack
echo done!

echo Deploying stack [Security_Groups]...
aws cloudformation deploy \
  --template-file sgroups.yaml \
  --stack-name app-security-stack
echo done!

echo Deploying stack [Redis]...
aws cloudformation deploy \
  --template-file redis.yaml \
  --stack-name app-redis-stack
echo done!

#aws cloudformation describe-stacks \
#  --stack-name app-redis-stack