https://jhooq.com/building-first-helm-chart-with-spring-boot/

-- create Helm files
helm create hello-world

// !!! modify generated files
https://jhooq.com/building-first-helm-chart-with-spring-boot/

-- check with
helm template hello-world

-- lint
helm lint hello-world

-- test
helm install hello-world --debug --dry-run hello-world

-- install
helm install my-first-hello-world hello-world

-- verify
helm list -a
kubectl get all

-- delete
helm delete my-first-hello-world

kubectl port-forward service/my-first-hello-world 8080:8080
curl  10.103.104.232:8080/item

===================
https://faun.pub/local-kubernetes-with-kind-helm-and-a-sample-service-4755e3e6eff4
======================================

kubectl port-forward deployment/my-first-hello-world 8080:8080
http://localhost:8080/item