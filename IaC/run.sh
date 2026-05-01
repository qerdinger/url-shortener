aws cloudformation deploy \
  --template-file vpc.yaml \
  --stack-name app-vpc-stack

aws cloudformation deploy \
  --template-file subs.yaml \
  --stack-name app-subnets-stack

aws cloudformation deploy \
  --template-file sgroups.yaml \
  --stack-name app-security-stack

aws cloudformation deploy \
  --template-file redis.yaml \
  --stack-name app-redis-stack

aws cloudformation describe-stacks \
  --stack-name app-redis-stack