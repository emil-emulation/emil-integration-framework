# EMiL - Rosetta integration service
[![Build Status](https://travis-ci.org/emil-emulation/emil-integration-framework.svg?branch=master)](https://travis-ci.org/emil-emulation/emil-integration-framework)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/ae1606d194c94c0d926805e697b94785)](https://www.codacy.com/app/marcus_2/emil-integration-framework)
[![codecov.io](https://codecov.io/github/emil-emulation/emil-integration-framework/coverage.svg?branch=master)](https://codecov.io/github/emil-emulation/emil-integration-framework?branch=master)

A microservice framework providing object storage metadata from an arbitrary archive to EMiL. The REST-Interface provides data as JSON or XML based on HTTP content negotiation (default: JSON).

## Introduction

### Implementation

To provide data from your archive to EMiL, your implementation has to implement the interface `ArchiveService`:

    @Service
    public class YourArchiveService implements ArchiveService<YourPid> {

      @Override
      public ArchiveObject getArchiveObject(YourPid pid) throws Exception {
        ...
      }

      @Override
      public IEPid getPid(String token) {
        ...
      }

    }


### Implementation

    java -jar <your implementation>.jar

Make sure that `application.yml` is the same directory as `<your implementation>.jar`.

### Usage:

    GET http://hostname/<IDENTIFIER>

    {
      "objectId": "IE12345",
      "files": [
        { "fileId": "FL12312.iso", "type": "ISO", "url": "http://rosetta-hostname/delivery/DeliveryManagerServlet?dps_pid=FL12312&dps_func=stream" },
        { "fileId": "FL12313.iso", "type": "ISO", "url": "http://rosetta-hostname/delivery/DeliveryManagerServlet?dps_pid=FL12313&dps_func=stream" },
        { "fileId": "FL12314.iso", "type": "ISO", "url": "http://rosetta-hostname/delivery/DeliveryManagerServlet?dps_pid=FL12314&dps_func=stream" }
      ]
    }

This service also offers a freely configurable demo object (see application.yml.template). The application.yml file has to be in the same directory as the jar file.

## Demo Mode

In application.yml one can define one PID with the desired response for testing. In case of this PID, the underlying archive won't be queried.

## Content Negotiation

If not ordered otherwise the service produces JSON. To get an XML representation, use `Accept: application/xml` header or add ".xml" at the end of the URL *(experimental)*.
