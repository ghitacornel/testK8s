-- start minikube, need docker started before
minikube start

-- verify with
kubectl get po -A

-- expect this
NAMESPACE              NAME                                        READY   STATUS    RESTARTS     AGE
default                my-first-hello-world-5489785b6-xhmrt        1/1     Running   0            7d22h
kube-system            coredns-64897985d-tkzqx                     1/1     Running   0            8d
kube-system            etcd-minikube                               1/1     Running   0            8d
kube-system            kube-apiserver-minikube                     1/1     Running   0            8d
kube-system            kube-controller-manager-minikube            1/1     Running   0            8d
kube-system            kube-proxy-pkcvw                            1/1     Running   0            8d
kube-system            kube-scheduler-minikube                     1/1     Running   0            8d
kube-system            storage-provisioner                         1/1     Running   1 (8d ago)   8d
kubernetes-dashboard   dashboard-metrics-scraper-58549894f-llqqf   1/1     Running   0            7d23h
kubernetes-dashboard   kubernetes-dashboard-ccd587f44-7b8mj        1/1     Running   0            7d23h

-- start dashboard
minikube dashboard

-- create docker image
minikube image build -t test-k8s-image:latest .

-- deploy via helm
helm install my-first-hello-world hello-world

-- expose port
kubectl port-forward deployment/my-first-hello-world 8080:8080

-- test
http://localhost:8080/item

-- stop
minikube stop

VERSION CHECKS

kubectl version
minikube version
docker version

UPGRADES

-- upgrade minikube, from admin console
choco upgrade minikube

-- upgrade k8s for minikube, from admin console
minikube start --kubernetes-version=v1.24.1

-- upgrade k8s-cli
choco install kubernetes-cli
choco upgrade kubernetes-cli